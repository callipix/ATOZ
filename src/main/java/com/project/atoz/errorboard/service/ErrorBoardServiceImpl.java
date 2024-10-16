package com.project.atoz.errorboard.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.atoz.dto.ErrorBoardDTO;
import com.project.atoz.dto.FilesDTO;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.errorboard.mapper.ErrorBoardMapper;
import com.project.atoz.fileupload.mapper.FileMapper;
import com.project.atoz.utiles.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class ErrorBoardServiceImpl implements ErrorBoardService {

	private final ErrorBoardMapper errorBoardMapper;
	private final FileMapper fileMapper;

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int insert(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception {
		// 게시글 등록
		errorBoardDTO.setContent(StringUtils.escapeDollorSign(errorBoardDTO.getContent()));

		List<Integer> fileNoList = new ArrayList<>();
		for (String fileKeyList : afterList) {
			fileNoList.add(this.fileMapper.getFileNoKey(fileKeyList));
		}

		int result = errorBoardMapper.insert(errorBoardDTO);

		// 최근 작업한 auto increment 값 가져오기
		int selectKey = this.fileMapper.getSelectKey();

		for (Integer fileNo : fileNoList) {
			FilesDTO filesDTO = new FilesDTO();
			filesDTO.setFile_no(fileNo);
			filesDTO.setPost_no(selectKey);
			filesDTO.setCategory_no(errorBoardDTO.getCategoryNo());
			result += this.fileMapper.updateFileInfo(filesDTO);
		}
		return result;
	}

	@Override
	public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception {
		// 게시글 페이징 + 검색
		return this.errorBoardMapper.getSearchSelectPage(sc);
	}

	@Override
	public int getSearchResultCount(SearchCondition sc) throws Exception {
		// 전체 게시글 수
		return this.errorBoardMapper.getSearchResultCount(sc);
	}

	@Override
	public ErrorBoardDTO getErrorBoardByErrBno(int errBno) {
		// 특정 게시글 조회
		ErrorBoardDTO errorBoardDTO = this.errorBoardMapper.getErrorBoardByErrBno(errBno);
		// 게시글 조회시 조회수 증가
		errorBoardMapper.increaseViewCount(errBno);
		return errorBoardDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int delete(Integer errBno, String writer) throws Exception {
		log.info("errBno = {}", errBno);
		// 게시글 삭제
		int result = errorBoardMapper.delete(errBno, writer);
		log.info("게시글 삭제 결과 1 나와야 = {}", result);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int modify(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception {
		// 게시글 업데이트
		errorBoardDTO.setContent(StringUtils.escapeDollorSign(errorBoardDTO.getContent()));

		int result = errorBoardMapper.modify(errorBoardDTO);

		List<Integer> fileNoList = new ArrayList<>();

		for (String fileKeyList : afterList) {
			fileNoList.add(this.fileMapper.getFileNoKey(fileKeyList));
		}

		for (Integer fileNo : fileNoList) {
			FilesDTO fileDTO = new FilesDTO();
			fileDTO.setFile_no(fileNo);
			fileDTO.setPost_no(errorBoardDTO.getErrBno());
			fileDTO.setCategory_no(errorBoardDTO.getCategoryNo());
			result += this.fileMapper.updateFileInfo(fileDTO);
		}
		log.info("result = {}", result);

		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int isCheckWriter(String writer, int errBno) {
		log.info("service errBno = {}", errBno);
		int result = this.errorBoardMapper.isCheckWriter(writer, errBno);
		log.info("service result = {}", result);
		return result;
	}
}