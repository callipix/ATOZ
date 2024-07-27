package com.project.myapp.utiles;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.project.myapp.dto.FilesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class AwsS3FileUploadServiceImpl implements AwsS3FileUploadService {

    private final AmazonS3 amazonS3;
    private final AwsConfig awsConfig;
    private final FileUpload fileUpload;

    @Autowired      // 생성자 주입
    public AwsS3FileUploadServiceImpl(AmazonS3 amazonS3,AwsConfig awsConfig, FileUpload fileUpload) {
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
        String ext = getFileExtension(originName);     // 확장자
        String storedName = makeFileName(originName);                           // 새로 생성된이름 -> DB에 저장될이름
        ObjectMetadata metadata = new ObjectMetadata();                         // 파일의 메타데이터
        metadata.setContentType("image/" + ext);                                // 이미지파일의 타입 -> 확장자
        String bucketName = awsConfig.getBucketName();

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

            // DB에 파일 정보를 저장, 파일번호, 원본파일명, UUID파일명, 파일타입(확장자), 파일크기(사이즈), 파일경로
            int result = uploadImages(filesDTO);
            if(result == 0){
                throw new IOException("DB 저장 오류");
            }
        } catch (IOException e){
            throw new IOException("이미지 업로드 오류");
        }
        return amazonS3.getUrl(bucketName, storedName).toString();
    }
    @Override
    public int uploadImages(FilesDTO filesDTO) throws IOException {

        System.out.println("filesDTO = " + filesDTO);
        int result = this.fileUpload.uploadFile(filesDTO);
        System.out.println("result = " + result);

        return result;
    }

}
