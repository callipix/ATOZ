package com.project.myapp.board.service;

import com.project.myapp.board.dao.BoardDAO;
import com.project.myapp.board.dao.CommentDAO;
import com.project.myapp.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class CommentServiceImpl implements CommentService {

    CommentDAO commentDAO;
    BoardDAO boardDAO;

    @Autowired
    public CommentServiceImpl(CommentDAO commentDAO, BoardDAO boardDAO) {
        this.commentDAO = commentDAO;
        this.boardDAO = boardDAO;
    }

    @Override
    public int commentCount(int bno) throws Exception {
        int result = commentDAO.commentCount(bno);
        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int deleteComment(Integer cno, Integer bno, String commenter) throws Exception {

        System.out.println("cno = " + cno);
        System.out.println("bno = " + bno);
        System.out.println("commenter = " + commenter);

        int result = this.boardDAO.updateCommentCount(bno , -1);

        System.out.println("result = " + result);

        result = this.commentDAO.deleteComment(cno , commenter);

        System.out.println("result = " + result);

        return result;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public CommentDTO insertComment(CommentDTO commentDTO) throws Exception {

        int resultBoard  = this.boardDAO.updateCommentCount(commentDTO.getBno() , 1);

        int result = this.commentDAO.insertComment(commentDTO);
        System.out.println("result = " + result);
        System.out.println("commentDTO = " + commentDTO);
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
        System.out.println("commentDTO = " + commentDTO);
        int result = commentDAO.updateComment(commentDTO);
        return result;
    }
}
