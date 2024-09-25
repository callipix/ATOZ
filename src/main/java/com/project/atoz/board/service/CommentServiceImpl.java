package com.project.atoz.board.service;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.atoz.board.mapper.BoardMapper;
import com.project.atoz.board.mapper.CommentMapper;
import com.project.atoz.dto.CommentDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class CommentServiceImpl implements CommentService {
	private final CommentMapper commentMapper;
	private final BoardMapper boardMapper;

	@Override
	public int commentCount(int bno) throws Exception {
		int result = this.commentMapper.commentCount(bno);
		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int deleteComment(Integer cno, Integer bno, String commenter) throws Exception {
		log.info("cno = {}", cno);
		log.info("bno = {}", bno);
		log.info("commenter = {}", commenter);

		int result = this.boardMapper.updateCommentCount(bno, -1);

		log.info("result = {}", result);

		result = this.commentMapper.deleteComment(cno, commenter);

		log.info("result = {}", result);

		return result;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public CommentDTO insertComment(CommentDTO commentDTO) throws Exception {

		int result = this.boardMapper.updateCommentCount(commentDTO.getBno(), 1);
		result += this.commentMapper.insertComment(commentDTO);

		log.info("insertComment for result = {}", result);
		log.info("insertComment for commentDTO = {}", commentDTO);
		return commentDTO;
	}

	@Override
	public List<CommentDTO> getCommentForBoard(int bno) throws Exception {
		List<CommentDTO> commentList = this.commentMapper.getCommentForBoard(bno);
		return commentList;
	}

	@Override
	public CommentDTO getCommentByCno(int cno) throws Exception {
		CommentDTO commentDTO = this.commentMapper.getCommentByCno(cno);
		return commentDTO;
	}

	@Override
	@Transactional(rollbackFor = Exception.class)
	public int updateComment(CommentDTO commentDTO) throws Exception {
		log.info("updateComment for commentDTO = {}", commentDTO);
		int result = this.commentMapper.updateComment(commentDTO);
		return result;
	}
}