package com.project.atoz.errorboard.dao;

import java.util.List;

import com.project.atoz.dto.ErrorBoardDTO;
import com.project.atoz.dto.SearchCondition;

public interface ErrorBoardDAO {

	// 게시글 등록
	int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO);

	// 게시글 리스트
	List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc);

	// 게시글 수
	int getSearchResultCount(SearchCondition sc);

	// 게시글 조회
	ErrorBoardDTO getErrorBoardByErrBno(int errBno);

	// 게시글 삭제
	int delete(Integer errBno, String writer);

	// 게시글 업데이트
	int update(ErrorBoardDTO errorBoardDTO);

	int increaseViewCount(int errBno);

	int getSelectKey();

	int isCheckWriter(String writer, int errBno);
}
