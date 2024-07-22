package com.project.myapp.board.dao;

import com.project.myapp.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class BoardDAOImpl implements BoardDAO {
    @Autowired
    SqlSession sqlSession;
    private static final String namespace = "com.project.myapp.board.dao.BoardMapper.";

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> getBoardList = sqlSession.selectList(namespace+"getBoardList");
        return getBoardList;
    }

    @Override
    public List<BoardDTO> getSelectPage(Map map) {
        List<BoardDTO> getSelectPage = sqlSession.selectList(namespace+"getSelectPage", map);
        return getSelectPage;
    }

    @Override
    public int getBoardCount() {
        int getBoardCount = sqlSession.selectOne(namespace+"getBoardCount");
        return getBoardCount;
    }


}
