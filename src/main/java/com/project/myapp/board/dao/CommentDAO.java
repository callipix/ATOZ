package com.project.myapp.board.dao;

import com.project.myapp.dto.CommentDTO;

import java.util.List;

public interface CommentDAO {

    public int deleteAllComment(int bno);

    public int commentCount(int bno);

    public int deleteComment(Integer cno , String commenter);

    public int insertComment(CommentDTO commentDTO);

    public List<CommentDTO> getCommentForBoard(int bno);

    public CommentDTO getCommentByCno(int cno);

    public int updateComment(CommentDTO commentDTO);
}
