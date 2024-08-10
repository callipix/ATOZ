package com.project.myapp.suggestion.dao;

import com.project.myapp.dto.SuggestionDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.*;
import java.util.stream.Stream;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "com.project.myapp.suggestion.dao.SuggestionMapper.";

    @Override
    public List<SuggestionDTO> getSuggestList(Map map) {

        List<SuggestionDTO> suggestionList = this.sqlSession.selectList(namespace + "getSelectPage", map);

        return suggestionList;
    }

    @Override
    public int insert(SuggestionDTO suggestionDTO) {
        int result = this.sqlSession.insert(namespace + "suggestCommentInsert", suggestionDTO);
        return result;
    }

    @Override
    public int update(SuggestionDTO suggestionDTO) {

        int result = this.sqlSession.update(namespace + "updateSuggestComment", suggestionDTO);
        return result;
    }

    @Override
    public int delete(Map map) {
        int result = this.sqlSession.update(namespace + "suggestCommentDelete", map);
        return result;
    }



    @Override
    public int getSuggestListCount() {

        int result = this.sqlSession.selectOne(namespace + "suggestCommentCount");
        return result;
    }

    @Override
    public int passCheck(int sno, String password) {
        Map<String , Object> map = new HashMap<>();
        map.put("sno", sno);
        map.put("password", password);
        int result = this.sqlSession.selectOne(namespace + "isEqualsIdNPass", map);
        return result;
    }
}
