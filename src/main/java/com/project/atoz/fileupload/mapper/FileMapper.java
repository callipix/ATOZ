package com.project.atoz.fileupload.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.atoz.dto.FilesDTO;

@Mapper
public interface FileMapper {

	int insertFileInfo(FilesDTO filesDTO);

	int deleteFileInfoByStoredName(String storedName);

	int updateFileInfo(FilesDTO filesDTO);

	int getFileNoKey(String imgAddress);

	int getSelectKey();

	List<FilesDTO> getDeleteList(int errBno);

}