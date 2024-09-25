package com.project.atoz.board.controller;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.atoz.board.mapper.BoardMapper;
import com.project.atoz.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardControllerTest {

	@Autowired
	private BoardMapper boardMapper;

	@Test
	public void getBoardList() {
		List<BoardDTO> boardList = boardMapper.getBoardList();

		for (BoardDTO boardDTO : boardList) {
			log.info("boardList = {}", boardDTO);
		}
	}
}