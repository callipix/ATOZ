package com.project.myapp.board.service;

import java.util.List;

import com.project.myapp.dto.CommentDTO;

public interface CommentService {

	public int commentCount(int bno) throws Exception;

	public int deleteComment(Integer cno, Integer bno, String commenter) throws Exception;

	//    public int insertComment(Integer bno , String content , String commenter) throws Exception;
	public CommentDTO insertComment(CommentDTO commentDTO) throws Exception;

	public List<CommentDTO> getCommentForBoard(int bno) throws Exception;

	public CommentDTO getCommentByCno(int cno) throws Exception;

	public int updateComment(CommentDTO commentDTO) throws Exception;
}
