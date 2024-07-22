package com.project.myapp.board.service;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.dto.BoardDTO;
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
}
