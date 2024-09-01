package com.project.myapp.board.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardControllerTest {

	@Autowired
	private BoardDAO boardDAO;

	@Test
	public void getBoardList() {
		List<BoardDTO> boardList = boardDAO.getBoardList();

		for (BoardDTO boardDTO : boardList) {
			log.info("boardList = {}", boardDTO);
		}
	}
}