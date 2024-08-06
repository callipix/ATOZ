package com.project.myapp.utiles;

import com.project.myapp.dto.FilesDTO;
import org.springframework.web.multipart.MultipartFile;

import java.io.IOException;
import java.util.List;
import java.util.Map;

public interface AwsS3FileUploadService {

    String saveFileToS3(MultipartFile image, String id) throws IOException;

    int uploadImages(FilesDTO filesDTO) throws IOException;

    int deleteImageFile(List<String> imgAddress, List<String> afterAddress) throws IOException;

    int deleteFileAwsS3(List<FilesDTO> filesDTO) throws IOException;
}
