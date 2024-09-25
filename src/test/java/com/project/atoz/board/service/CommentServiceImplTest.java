package com.project.atoz.board.service;

import static org.junit.Assert.*;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.atoz.board.mapper.CommentMapper;
import com.project.atoz.dto.CommentDTO;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class CommentServiceImplTest {

	@Autowired
	CommentMapper commentMapper;

	@Test
	public void commentCount() {
	}

	@Test
	public void deleteComment() {
	}

	@Test
	public void insertComment() {

		CommentDTO commentDTO = new CommentDTO(1, 0, "comment테스트", "aaaa1234");
		assertTrue(commentMapper.insertComment(commentDTO) == 1);
		assertTrue(commentMapper.commentCount(commentDTO.getBno()) == 1);

		commentDTO = new CommentDTO(1, 0, "comment", "asdf");
		assertTrue(commentMapper.insertComment(commentDTO) == 1);
		assertTrue(commentMapper.commentCount(1) == 2);
	}

	@Test
	public void getCommentForBoard() {
	}

	@Test
	public void getCommentByCno() {
	}

	@Test
	public void updateComment() {
	}
}