package com.project.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.board.dao.CommentDAO;
import com.project.myapp.dto.CommentDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentDAO commentDAO;
	private final BoardDAO boardDAO;

	@Override
	public int commentCount(int bno) throws Exception {
		int result = commentDAO.commentCount(bno);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteComment(Integer cno, Integer bno, String commenter) throws Exception {

		log.info("cno = {}", cno);
		log.info("bno = {}", bno);
		log.info("commenter = {}", commenter);

		int result = this.boardDAO.updateCommentCount(bno, -1);

		log.info("result = {}", result);

		result = this.commentDAO.deleteComment(cno, commenter);

		log.info("result = {}", result);

		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CommentDTO insertComment(CommentDTO commentDTO) throws Exception {

		int resultBoard = this.boardDAO.updateCommentCount(commentDTO.getBno(), 1);

		int result = this.commentDAO.insertComment(commentDTO);
		log.info("insertComment for result = {}", result);
		log.info("insertComment for commentDTO = {}", commentDTO);
		return commentDTO;
	}

	@Override
	public List<CommentDTO> getCommentForBoard(int bno) throws Exception {
		List<CommentDTO> commentList = commentDAO.getCommentForBoard(bno);
		return commentList;
	}

	@Override
	public CommentDTO getCommentByCno(int cno) throws Exception {
		CommentDTO commentDTO = commentDAO.getCommentByCno(cno);
		return commentDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateComment(CommentDTO commentDTO) throws Exception {
		log.info("updateComment for commentDTO = {}", commentDTO);
		int result = commentDAO.updateComment(commentDTO);
		return result;
	}
}
