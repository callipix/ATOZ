package com.project.myapp.fileupload;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.myapp.dto.FilesDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class FileUpload {

	private final SqlSession sqlSession;
	private static final String namespace = "com.project.myapp.utiles.FileMapper.";

	public int uploadFile(FilesDTO filesDTO) {
		int result = this.sqlSession.insert(namespace + "insertFileInfo", filesDTO);

		return result;
	}

	public int deleteFile(String storedName) {
		log.info("FileUpload.class storedName = {}", storedName);
		int result = this.sqlSession.delete(namespace + "deleteFileInfoByStoredName", storedName);
		return result;
	}

	public int updateImages(FilesDTO filesDTO) {
		log.info("updateImages filesDTO = {}", filesDTO);
		int result = this.sqlSession.update(namespace + "updateFileInfo", filesDTO);
		return result;
	}

	public int getFileNoKeyList(String imgAddress) {
		int fileNoKey = sqlSession.selectOne(namespace + "getFileNoKey", imgAddress);
		return fileNoKey;
	}

	public int selectKey() {
		int selectKey = this.sqlSession.selectOne(namespace + "getSelectKey");
		return selectKey;
	}

	public List<FilesDTO> getDeleteList(int errBno) {
		List<FilesDTO> deleteList = this.sqlSession.selectList(namespace + "getDeleteList", errBno);
		return deleteList;
	}
}