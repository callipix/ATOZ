package com.project.myapp.utiles;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.*;
import com.project.myapp.dto.FilesDTO;
import com.project.myapp.errorboard.dao.ErrorBoardDAO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.net.URLDecoder;
import java.util.*;

@Service
public class AwsS3FileUploadServiceImpl implements AwsS3FileUploadService {

    @Value("${cloud.aws.s3.bucketName}")
    private String bucketName;
    private static final Logger logger = LoggerFactory.getLogger(UploadController.class);

    private final ErrorBoardDAO errorBoardDAO;
    private final AmazonS3 amazonS3;
    private final AwsConfig awsConfig;
    private final FileUpload fileUpload;


    @Autowired      // 생성자 주입
    public AwsS3FileUploadServiceImpl(ErrorBoardDAO errorBoardDAO, AmazonS3 amazonS3, AwsConfig awsConfig, FileUpload fileUpload) {
        this.errorBoardDAO = errorBoardDAO;
        this.amazonS3 = amazonS3;
        this.awsConfig = awsConfig;
        this.fileUpload = fileUpload;
    }

    // UUID를 사용해서 저장할 파일 이름을 생성(중복방지)
    private String makeFileName(String originName){
        String uuidName = UUID.randomUUID().toString();
        System.out.println("makeFileName uuidName = " + uuidName);
        return uuidName + "_" + originName;
    }

    // 확장자를 반환하는 메서드
    private String getFileExtension(String fileName){
        int dotIndex = fileName.lastIndexOf(".");
        // 점이 없거나 점이 문자열의 마지막 위치에 있을때(ssss..jpg 처럼 파일명 자체에 점이 있을때)
        if(dotIndex == -1 || dotIndex == fileName.length()-1){
            return "";
        }
        // 확장자 분리할 필요가 없네.. 이미 getContetType()에서 형식/타입 같이오는데?
        return fileName.substring(dotIndex+1);
    }
    @Override
    @Transactional(rollbackFor = IOException.class)
    public String saveFileToS3(MultipartFile image, String id) throws IOException {
        // AWS S3에 이미지를 업로드 하는 메서드
        String originName = image.getOriginalFilename();                        // 원본파일 이름
        String ext = getFileExtension(originName);                              // 확장자
        String storedName = makeFileName(originName);                           // 새로 생성된이름 -> DB에 저장될이름
        ObjectMetadata metadata = new ObjectMetadata();                         // 파일의 메타데이터
        metadata.setContentType("image/" + ext);                                // 이미지파일의 타입 -> 확장자 이미지 업로드
        String bucketName = awsConfig.getBucketName();
            Map<String , Object> map = new HashMap<>();

        try{
            PutObjectResult putObjectResult = amazonS3.putObject(new PutObjectRequest(
                    bucketName, storedName, image.getInputStream(), metadata
            ).withCannedAcl(CannedAccessControlList.PublicRead));

            FilesDTO filesDTO = new FilesDTO();
            filesDTO.setOriginal_name(originName);
            filesDTO.setStored_name(storedName);
            filesDTO.setFile_type(image.getContentType());
            filesDTO.setFile_size(image.getSize());
            filesDTO.setFile_path(amazonS3.getUrl(bucketName, storedName).toString());
            filesDTO.setId(id);

            int result = uploadImages(filesDTO);
        } catch (IOException e){
            throw new IOException("이미지 업로드 오류");
        }
        return amazonS3.getUrl(bucketName, storedName).toString();
    }
    @Override
    @Transactional(rollbackFor = IOException.class)
    public int uploadImages(FilesDTO filesDTO) throws IOException {
        // DB에 파일 정보를 저장하는 메서드
        System.out.println("filesDTO = " + filesDTO);
        int result = this.fileUpload.uploadFile(filesDTO);
        int key = this.errorBoardDAO.getSelectKey();
        return result;
    }
    @Override
    @Transactional(rollbackFor = IOException.class)
    public int deleteImageFile(List<String> imageAddress,List<String> afterAddress) throws IOException {
        // 게시글 내에서 이미지를 추가하거나 삭제했을시 AWS S3에도 업로드한 이미지만
        // 존재하고 기존 이미지를 삭제하는 메서드(DB에 존재하는 파일 정보도 삭제)
        int result = 0;
        for (String imgURL : imageAddress) {
            String decodeURL = "";

            try {
                decodeURL = URLDecoder.decode(imgURL, "UTF-8");
                String awsURL = "https://test-bucket-myappaws.s3.ap-northeast-2.amazonaws.com/";
                imgURL = decodeURL.substring(awsURL.length());

                System.out.println("imgURL = " + imgURL);
                amazonS3.deleteObject(awsConfig.getBucketName(), imgURL);

                result += this.fileUpload.deleteFile(imgURL);
                System.out.println("파일정보 삭제 결과 = " + result);

                if (result == 0) {
                    throw new IOException("DB 파일정보 삭제 오류");
                }
                System.out.println("파일삭제 성공시 = " + result);
            } catch (IOException e) {
                e.printStackTrace();
                throw new IOException("파일정보 저장 오류");
            }
        }
        return result;
    }
}
