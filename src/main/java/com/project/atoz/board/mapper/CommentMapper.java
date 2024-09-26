package com.project.atoz.board.mapper;

import java.util.List;

import com.project.atoz.dto.CommentDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface CommentMapper {

	int deleteAllComment(int bno);

	int commentCount(int bno);

	int deleteComment(Integer cno, String commenter);

	int insertComment(CommentDTO commentDTO);

	List<CommentDTO> getCommentForBoard(int bno);

	CommentDTO getCommentByCno(int cno);

	int updateComment(CommentDTO commentDTO);
}
