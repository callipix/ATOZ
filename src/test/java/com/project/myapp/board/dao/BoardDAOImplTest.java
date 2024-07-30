package com.project.myapp.board.dao;

import com.project.myapp.dto.BoardDTO;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardDAOImplTest {

    @Autowired
    private BoardDAO boardDAO;

    @Test
    public void getBoardList() {
    }

    @Test
    public void getSelectPage() {
    }

    @Test
    public void getBoardCount() {
    }

    @Test
    public void getBoardByBno() {
    }

    @Test
    public void insertBoard() {
//        deleteAll();
        int result = 0;
//        for(int i = 1; i <= 200; i++){
//            BoardDTO boardDTO = new BoardDTO("제목테스트"+ i ,"내용테스트"+i, "aaaa1234");
//            result += boardDAO.insertBoard(boardDTO);
//        }
        BoardDTO boardDTO = new BoardDTO("제목테스트" ,"내용테스트", "aaaa1234");
        result += boardDAO.insertBoard(boardDTO);
        System.out.println("result = " + result);
        assertTrue( result == 1);
    }

    @Test
    public void updateBoardByIdNBno() {
    }

    @Test
    public void deleteForAdmin() {
    }

    @Test
    public void deleteAll() {
        this.boardDAO.deleteAll();
    }

    @Test
    public void deleteByIdNBno() {
    }

    @Test
    public void increaseViewCount() {
    }

    @Test
    public void updateCommentCount() {
    }

    @Test
    public void getSearchSelectPage() {
    }

    @Test
    public void getSearchResultCount() {
    }
}