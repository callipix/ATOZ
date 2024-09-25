package com.project.atoz.board.mapper;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.atoz.dto.BoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class BoardMapperImplTest {

	@Autowired
	private BoardMapper boardMapper;

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
		for (int i = 1; i <= 20; i++) {
			BoardDTO boardDTO = new BoardDTO("MySQL 사용해보기 " + i, "내용 잘 들어가나?" + i, "xxxx123a");
			result += boardMapper.insertBoard(boardDTO);
		}
		for (int i = 21; i <= 40; i++) {
			BoardDTO boardDTO = new BoardDTO("Junit을 사용하여 Test Code로 게시물 insert 해보기 " + i, "내용테스트" + i, "aaaa1234");
			result += boardMapper.insertBoard(boardDTO);
		}
		for (int i = 41; i <= 60; i++) {
			BoardDTO boardDTO = new BoardDTO("Postman 사용해서 url응답 확인하기 " + i, "고려해야 할 요소들이 너무 많다" + i, "asdfzzzz1");
			result += boardMapper.insertBoard(boardDTO);
		}
		// for (int i = 61; i <= 80; i++) {
		// 	BoardDTO boardDTO = new BoardDTO("AWS로 서버, 파일업로드 해보기 " + i, "내용 잘 들어 가는지?" + i, "vvvv1234");
		// 	result += boardMapper.insertBoard(boardDTO);
		// }
		// for (int i = 81; i <= 100; i++) {
		// 	BoardDTO boardDTO = new BoardDTO("현재까지 깃 링크 연동완료 " + i, "내용테스트중" + i, "aaaa1234");
		// 	result += boardMapper.insertBoard(boardDTO);
		// }
		log.info("result = {}", result);
		assertTrue(result == 60);
	}

	@Test
	public void updateBoardByIdNBno() {
	}

	@Test
	public void deleteForAdmin() {
	}

	@Test
	public void deleteAll() {
		this.boardMapper.deleteAll();
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