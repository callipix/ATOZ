package com.project.myapp.errorboard.service;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.errorboard.dao.ErrorBoardDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ErrorBoardServiceImpl implements ErrorBoardService {

    @Autowired
    ErrorBoardDAO errorBoardDAO;

    @Override
    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO) {
        int result = errorBoardDAO.insertErrorBoardMapper(errorBoardDTO);
        return result;
    }

    @Override
    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) {
        return this.errorBoardDAO.getSearchSelectPage(sc);
    }

    @Override
    public int getSearchResultCount(SearchCondition sc) {
        return this.errorBoardDAO.getSearchResultCount(sc);
    }
}
