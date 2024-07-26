package com.project.myapp.utiles;


import com.amazonaws.services.s3.AmazonS3;
import com.amazonaws.services.s3.model.CannedAccessControlList;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.PutObjectRequest;
import com.amazonaws.services.s3.model.PutObjectResult;
import com.project.myapp.dto.FilesDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.UUID;

@Service
public class AwsS3FileUploadServiceImpl implements AwsS3FileUploadService {

    private final AmazonS3 amazonS3;
    private AwsConfig awsConfig;
    private FileUpload fileUpload;

    @Value("${cloud.aws.s3.bucket}")
    private String bucketName;

    @Autowired
    public AwsS3FileUploadServiceImpl(AmazonS3 amazonS3 , AwsConfig awsConfig, FileUpload fileUpload) {
        this.amazonS3 = amazonS3;
    }

    private String makeFileName(String originName){
        String uuidName = UUID.randomUUID().toString();
        System.out.println("makeFileName uuidName = " + uuidName);
        return uuidName + "_" + originName;
    }

    @Override
    public String saveFileToS3(MultipartFile image) throws IOException {
        // AWS S3에 이미지를 업로드 하는 메서드
        String originName = image.getOriginalFilename();                        // 원본파일 이름
        String ext = originName.substring(originName.lastIndexOf("."));     // 확장자
        String storedName = makeFileName(originName);                           // 새로 생성된이름 -> DB에 저장될이름
        ObjectMetadata metadata = new ObjectMetadata();                         // 파일의 메타데이터
        metadata.setContentType("image/" + ext);                                // 이미지파일의 타입 -> 확장자

        try{
            PutObjectResult putObjectResult = amazonS3.putObject(new PutObjectRequest(
                    bucketName, storedName, image.getInputStream(), metadata
            ).withCannedAcl(CannedAccessControlList.PublicRead));
        } catch (IOException e){
            throw new IOException("이미지 업로드 오류");
        }
        System.out.println("saveFileToS3 bucketName = " + bucketName);
        System.out.println("saveFileToS3 metadata = " + metadata);
        System.out.println("saveFileToS3 storedName = " + storedName);
        System.out.println("saveFileToS3 ext = " + ext);
        System.out.println("saveFileToS3 originName = " + originName);
        System.out.println("saveFileToS3 image = " + image);
        return storedName;
    }

    @Override
    public int uploadImages(MultipartFile image) throws IOException {

        String storedName = saveFileToS3(image);
        String storedImagePath = amazonS3.getUrl(bucketName, storedName).toString() ;      // 이미지가 저장될 실제 경로

        FilesDTO filesDTO = new FilesDTO();

        filesDTO.setOriginal_name(image.getOriginalFilename());              // 오리지날 네임
        filesDTO.setStored_name(saveFileToS3(image));                        // uuid로 생성된 s3 업로드 파일명
        filesDTO.setFile_type(image.getContentType());                       // 파일타입
        filesDTO.setFile_size(image.getSize());                              // 파일사이즈
        filesDTO.setFile_path(storedImagePath);                              // 파일의 경로

        System.out.println("filesDTO = " + filesDTO);

        int result = this.fileUpload.uploadFile(filesDTO);
        return result;
    }

}
