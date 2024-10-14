package com.project.atoz.board.service;

import java.util.List;

import com.project.atoz.dto.CommentDTO;

public interface CommentService {

	CommentDTO insertComment(CommentDTO commentDTO) throws Exception;

	int deleteComment(Integer cno, Integer bno, String commenter) throws Exception;

	int updateComment(CommentDTO commentDTO) throws Exception;

	List<CommentDTO> getCommentForBoard(int bno) throws Exception;

}
