package com.project.myapp.board.controller;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.dto.BoardDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

import static org.junit.Assert.*;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardControllerTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void getBoardList() {
        List<BoardDTO> boardList = boardDAO.getBoardList();

        for(BoardDTO boardDTO : boardList){
            System.out.println("boardList = " + boardDTO);
        }
    }
}