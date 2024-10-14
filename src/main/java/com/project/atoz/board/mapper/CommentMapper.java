package com.project.atoz.board.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import com.project.atoz.dto.CommentDTO;

@Mapper
public interface CommentMapper {

	int commentCount(int bno);

	int deleteComment(Integer cno, String commenter);

	int insertComment(CommentDTO commentDTO);

	List<CommentDTO> getCommentForBoard(int bno);

	CommentDTO getCommentByCno(int cno);

	int updateComment(CommentDTO commentDTO);
}
