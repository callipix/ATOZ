package com.project.myapp.board.service;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Service
public class BoardServiceImpl implements BoardService{

    @Autowired
    private BoardDAO boardDAO;

    @Override
    public List<BoardDTO> getBoardList() {
        List<BoardDTO> getBoardList = boardDAO.getBoardList();
        return getBoardList;
    }

    @Override
    public List<BoardDTO> getSelectPage(Map map) {
        List<BoardDTO> getSelectPage = boardDAO.getSelectPage(map);
        return getSelectPage;
    }

    @Override
    public int getBoardCount() {

        int getBoardCount = boardDAO.getBoardCount();
        return getBoardCount;
    }

    @Override
    public BoardDTO getBoardByBno(int bno) {
        BoardDTO boardDTO = boardDAO.getBoardByBno(bno);
        boardDAO.increaseViewCount(bno);
        return boardDTO;
    }

    @Override
    public int insertBoard(BoardDTO board) throws Exception {
        int result = boardDAO.insertBoard(board);
        return result;
    }

    @Override
    public int updateBoardByIdNBno(BoardDTO board) throws Exception {
        int result = boardDAO.updateBoardByIdNBno(board);
        return result;
    }

    @Override
    public int deleteForAdmin(int id) throws Exception {
        int result = boardDAO.deleteForAdmin(id);
        return result;
    }

    @Override
    public int deleteAll() throws Exception {
        int result = boardDAO.deleteAll();
        return result;
    }

    @Override
    public int deleteByIdNBno(Map map) throws Exception {
        int result = boardDAO.deleteByIdNBno(map);
        return result;
    }

    @Override
    public List<BoardDTO> getSearchSelectPage(SearchCondition sc) {
        return this.boardDAO.getSearchSelectPage(sc);
    }

}
