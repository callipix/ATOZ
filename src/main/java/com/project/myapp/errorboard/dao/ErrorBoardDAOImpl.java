package com.project.myapp.errorboard.dao;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.vo.ErrLogFileDto;
import org.apache.http.impl.io.AbstractMessageParser;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

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

    @Override
    public ErrorBoardDTO getErrorBoardByErrBno(int errBno) {
        ErrorBoardDTO errorBoardDTO = sqlSession.selectOne(namespace + "getErrorBoardByErrBno", errBno);
        return errorBoardDTO;
    }

    @Override
    public int delete(Integer errBno , String writer) {
        Map map = new HashMap();
        map.put("errBno", errBno);
        map.put("writer", writer);
        int result = sqlSession.delete(namespace + "delete", map);
        return result;
    }

    @Override
    public int update(ErrorBoardDTO errorBoardDTO) {
        int result = sqlSession.update(namespace + "modify", errorBoardDTO);
        return result;
    }

    @Override
    public int increaseViewCount(int errBno) {
        int result = sqlSession.update(namespace + "increaseViewCount", errBno);
        return result;
    }
    @Override
    public int getSelectKey(){
        int result = sqlSession.selectOne(namespace + "getSelectKey");
        System.out.println("getSelectKey result = " + result);
        return result;
    }
}
