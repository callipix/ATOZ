package com.project.atoz.errorboard.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.atoz.dto.ErrorBoardDTO;
import com.project.atoz.dto.SearchCondition;

@Mapper
public interface ErrorBoardMapper {

	// 게시글 등록
	int insert(ErrorBoardDTO errorBoardDTO);

	// 게시글 리스트
	List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc);

	// 게시글 수
	int getSearchResultCount(SearchCondition sc);

	// 게시글 조회
	ErrorBoardDTO getErrorBoardByErrBno(int errBno);

	// 게시글 삭제
	int delete(Integer errBno, String writer);

	// 게시글 업데이트
	int modify(ErrorBoardDTO errorBoardDTO);

	int increaseViewCount(int errBno);

	 int getSelectKey();

	int isCheckWriter(String writer, int errBno);
}
