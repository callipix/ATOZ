package com.project.myapp.utiles;

import com.project.myapp.dto.FilesDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;

public interface AwsS3FileUploadService {
//
    String saveFileToS3(MultipartFile image, String id) throws IOException;
//
    int uploadImages(FilesDTO filesDTO) throws IOException;
//
//    // 사진 업로드
//
//    // 사진 삭제
//
//    // 사진 수정
//
//    // 사진
}
