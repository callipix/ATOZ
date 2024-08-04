package com.project.myapp.errorboard.dao;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.vo.ErrLogFileDto;

import java.util.List;
import java.util.Map;

public interface ErrorBoardDAO {

    // 게시글 등록
    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO);

    // 게시글 리스트
    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc);

    // 게시글 수
    public int getSearchResultCount(SearchCondition sc);

    // 게시글 조회
    public ErrorBoardDTO getErrorBoardByErrBno(int errBno);

    // 게시글 삭제
    public int delete(Integer errBno , String writer);

    // 게시글 업데이트
    public int update(ErrorBoardDTO errorBoardDTO);

    public int increaseViewCount(int errBno);

    public int getSelectKey();

    int isCheckWriter(String writer, int errBno);
}
