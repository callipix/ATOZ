package com.project.myapp.errorboard.service;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;

import java.util.List;
import java.util.Map;

public interface ErrorBoardService {
    // 게시글 등록
    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO) throws Exception;

    // 게시글 리스트
    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) throws Exception;

    // 게시글 수
    public int getSearchResultCount(SearchCondition sc) throws Exception;

    // 게시글 조회
    public ErrorBoardDTO getErrorBoardByErrBno(int errBno);

    // 게시글 삭제
    public int delete(Integer errBno , String writer) throws Exception;

    // 게시글 업데이트
    public int update(ErrorBoardDTO errorBoardDTO) throws Exception;

}
