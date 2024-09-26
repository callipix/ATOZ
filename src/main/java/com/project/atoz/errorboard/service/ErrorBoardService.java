package com.project.atoz.errorboard.service;

import java.util.List;

import com.project.atoz.dto.ErrorBoardDTO;
import com.project.atoz.dto.SearchCondition;

public interface ErrorBoardService {
	// 게시글 등록
	int insert(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception;

	// 게시글 리스트
	List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;

	// 게시글 수
	int getSearchResultCount(SearchCondition sc) throws Exception;

	// 게시글 조회
	ErrorBoardDTO getErrorBoardByErrBno(int errBno);

	// 게시글 삭제
	int delete(Integer errBno, String writer) throws Exception;

	// 게시글 업데이트
	int modify(ErrorBoardDTO errorBoardDTO, List<String> afterList) throws Exception;

	int isCheckWriter(String writer, int errBno);

}
