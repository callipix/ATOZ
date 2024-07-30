package com.project.myapp.errorboard.dao;

import com.project.myapp.dto.ErrorBoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class ErrorBoardDAOImpl implements ErrorBoardDAO{

    private static final String namespace = "com.project.myapp.errorboard.dao.ErrorBoardMapper.";

    @Autowired
    private SqlSession sqlSession;

    public int insertErrorBoardMapper(ErrorBoardDTO errorBoardDTO) {
        return sqlSession.insert(namespace + "insert", errorBoardDTO);
    }

    public int updateErrorBoardMapper(ErrorBoardDTO errorBoardDTO) {
        int result = sqlSession.update(namespace + "modify", errorBoardDTO);
        return result;
    }

}
