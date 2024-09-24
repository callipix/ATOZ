package com.project.atoz.board.dao;

import java.util.List;

import com.project.atoz.dto.CommentDTO;

public interface CommentDAO {

	public int deleteAllComment(int bno);

	public int commentCount(int bno);

	public int deleteComment(Integer cno, String commenter);

	public int insertComment(CommentDTO commentDTO);

	public List<CommentDTO> getCommentForBoard(int bno);

	public CommentDTO getCommentByCno(int cno);

	public int updateComment(CommentDTO commentDTO);
}
