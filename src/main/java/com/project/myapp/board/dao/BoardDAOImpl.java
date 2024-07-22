package com.project.myapp.board.dao;

import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.SearchCondition;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
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

    @Override
    public BoardDTO getBoardByBno(int bno) {
        BoardDTO boardDTO = sqlSession.selectOne(namespace+"getBoardByBno", bno);
        return boardDTO;
    }

    @Override
    public int insertBoard(BoardDTO board) {
        int insertBoard = sqlSession.insert(namespace+"insertBoard", board);
        return insertBoard;
    }

    @Override
    public int updateBoardByIdNBno(BoardDTO board) {
        int updateBoard = sqlSession.update(namespace+"updateBoardByIdNBno", board);
        return updateBoard;
    }

    @Override
    public int deleteForAdmin(int id) {
        int deleteBoard = sqlSession.delete(namespace+"deleteForAdmin", id);
        return deleteBoard;
    }

    @Override
    public int deleteAll() {
        int deleteBoard = sqlSession.delete(namespace+"deleteAll");
        return deleteBoard;
    }

    @Override
    public int deleteByIdNBno(Map map) {
        int deleteBoard = sqlSession.delete(namespace+"deleteByIdNBno", map);
        return deleteBoard;
    }

    @Override
    public int increaseViewCount(int bno) {
        int increaseViewCount = sqlSession.update(namespace+"increaseViewCount", bno);
        return increaseViewCount;
    }

    @Override
    public int updateCommentCount(Integer bno, int cnt) {
        Map map = new HashMap();
        map.put("cnt", cnt);
        map.put("bno", bno);
        int updateCommentCount = sqlSession.update(namespace+"updateCommentCount", map);
        return updateCommentCount;
    }
    @Override
    public List<BoardDTO> getSearchSelectPage(SearchCondition sc){
        return sqlSession.selectList(namespace+"getSearchSelectPage", sc);
    }
}
