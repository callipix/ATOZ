package com.project.myapp.board.dao;

import com.project.myapp.dto.CommentDTO;
import lombok.RequiredArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Repository
@RequiredArgsConstructor
public class CommentDAOImpl implements CommentDAO{

    private final SqlSession sqlSession;
    private static final String NAMESPACE = "com.project.myapp.board.dao.CommentMapper.";

    @Override
    public int deleteAllComment(int bno){
        int result = sqlSession.delete(NAMESPACE+"deleteAllComment",bno);
        return result;
    }

    @Override
    public int commentCount(int bno) {
        int result = sqlSession.selectOne(NAMESPACE+"commentCount",bno);
        return result;
    }

    @Override
    public int deleteComment(Integer cno , String commenter) {
        Map map = new HashMap();
        map.put("cno",cno);
        map.put("commenter",commenter);
        int result = sqlSession.delete(NAMESPACE+"deleteComment",map);
        return result;
    }

    @Override
    public int insertComment(CommentDTO commentDTO) {
        int result = sqlSession.insert(NAMESPACE+"insertComment",commentDTO);
        return result;
    }

    @Override
    public List<CommentDTO> getCommentForBoard(int bno) {
        List<CommentDTO> commentListForBoard = sqlSession.selectList(NAMESPACE+"getCommentForBoard",bno);
        return commentListForBoard;
    }

    @Override
    public CommentDTO getCommentByCno(int cno) {
        CommentDTO commentDTO = sqlSession.selectOne(NAMESPACE+"getCommentByCno",cno);
        return commentDTO;
    }

    @Override
    public int updateComment(CommentDTO commentDTO) {
        int result = sqlSession.update(NAMESPACE+"updateComment",commentDTO);
        return result;
    }
}
