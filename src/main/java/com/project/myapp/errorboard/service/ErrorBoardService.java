package com.project.myapp.errorboard.service;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;

import java.util.List;

public interface ErrorBoardService {
    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO);

    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc);

    public int getSearchResultCount(SearchCondition sc);

}
