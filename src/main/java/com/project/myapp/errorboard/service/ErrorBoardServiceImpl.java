package com.project.myapp.errorboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.FilesDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.errorboard.dao.ErrorBoardDAO;
import com.project.myapp.fileupload.FileUpload;
import com.project.myapp.utiles.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ErrorBoardServiceImpl implements ErrorBoardService {

	private final ErrorBoardDAO errorBoardDAO;
	private final FileUpload fileUpload;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception {
		// 게시글 등록
		errorBoardDTO.setContent(StringUtils.escapeDollorSign(errorBoardDTO.getContent()));

		List<Integer> fileNoList = new ArrayList<>();
		for (String fileKeyList : afterList) {
			fileNoList.add(this.fileUpload.getFileNoKeyList(fileKeyList));
		}

		int result = errorBoardDAO.insertErrorBoardMapper(errorBoardDTO);

		// 최근에 작업했던(auto_increment값 가져오기)
		int selectKey = this.fileUpload.selectKey();

		for (Integer fileNo : fileNoList) {
			FilesDTO filesDTO = new FilesDTO();
			filesDTO.setFile_no(fileNo);
			filesDTO.setPost_no(selectKey);
			filesDTO.setCategory_no(errorBoardDTO.getCategoryNo());
			result += this.fileUpload.updateImages(filesDTO);
		}
		return result;
	}

	@Override
	public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception {
		// 게시글 페이징 + 검색
		return this.errorBoardDAO.getSearchSelectPage(sc);
	}

	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception {
		// 전체 게시글 수
		return this.errorBoardDAO.getSearchResultCount(sc);
	}

	@Override
	public ErrorBoardDTO getErrorBoardByErrBno(int errBno) {
		// 특정 게시글 조회
		ErrorBoardDTO errorBoardDTO = this.errorBoardDAO.getErrorBoardByErrBno(errBno);
		// 게시글을 조회하면 조회수가 증가
		errorBoardDAO.increaseViewCount(errBno);
		return errorBoardDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Integer errBno, String writer) throws Exception {
		log.info("errBno = {}", errBno);
		// 게시글 삭제
		int result = errorBoardDAO.delete(errBno, writer);
		log.info("게시글 삭제결과 1 나와야함 = {}", result);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int update(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception {
		// 게시글 업데이트
		errorBoardDTO.setContent(StringUtils.escapeDollorSign(errorBoardDTO.getContent()));

		int result = errorBoardDAO.update(errorBoardDTO);

		List<Integer> fileNoList = new ArrayList<>();

		for (String fileKeyList : afterList) {
			fileNoList.add(this.fileUpload.getFileNoKeyList(fileKeyList));
		}

		for (Integer fileNo : fileNoList) {
			FilesDTO fileDTO = new FilesDTO();
			fileDTO.setFile_no(fileNo);
			fileDTO.setPost_no(errorBoardDTO.getErrBno());
			fileDTO.setCategory_no(errorBoardDTO.getCategoryNo());
			result += this.fileUpload.updateImages(fileDTO);
		}
		log.info("result = {}", result);

		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int isCheckWriter(String writer, int errBno) {
		log.info("service errBno = {}", errBno);
		int result = this.errorBoardDAO.isCheckWriter(writer, errBno);
		log.info("service result = {}", result);
		return result;
	}
}