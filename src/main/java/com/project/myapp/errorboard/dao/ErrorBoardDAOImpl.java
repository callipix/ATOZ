package com.project.myapp.errorboard.dao;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class ErrorBoardDAOImpl implements ErrorBoardDAO{

    private static final String namespace = "com.project.myapp.errorboard.dao.ErrorBoardMapper.";

    @Autowired
    private SqlSession sqlSession;

    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO) {
        return sqlSession.insert(namespace + "insert", errorBoardDTO);
    }

    @Override
    public List<ErrorBoardDTO> getSearchSelectPage(SearchCondition sc) {

        List<ErrorBoardDTO> list = sqlSession.selectList(namespace + "getSearchSelectPage", sc);
        return list;
    }

    @Override
    public int getSearchResultCount(SearchCondition sc) {

        int result = sqlSession.selectOne(namespace + "getSearchResultCount", sc);

        return result;
    }

    public int updateErrorBoardMapper(ErrorBoardDTO errorBoardDTO) {

        int result = sqlSession.update(namespace + "modify", errorBoardDTO);

        return result;
    }



}
