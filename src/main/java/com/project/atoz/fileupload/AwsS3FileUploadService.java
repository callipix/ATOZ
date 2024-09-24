package com.project.atoz.fileupload;

import java.io.IOException;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import com.project.atoz.dto.FilesDTO;

public interface AwsS3FileUploadService {

	String saveFileToS3(MultipartFile image, String id) throws IOException;

	int uploadImages(FilesDTO filesDTO) throws IOException;

	int deleteImageFile(List<String> imgAddress, List<String> afterAddress) throws IOException;

	int deleteFileAwsS3(List<FilesDTO> filesDTO) throws IOException;
}
