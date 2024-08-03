package com.project.myapp.suggestion.dao;

import com.project.myapp.dto.SuggestionDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

@Repository
public class SuggestionDAOImpl implements SuggestionDAO {

    private SqlSession sqlSession;

    private final String namespace = "com.project.myapp.suggestion.dao.SuggestionMapper.";

    @Override
    public List<SuggestionDTO> getSuggestList() {
        return List.of();
    }

    @Override
    public int insert(SuggestionDTO suggestionDTO) {
        return 0;
    }

    @Override
    public int update(SuggestionDTO suggestionDTO) {
        return 0;
    }

    @Override
    public int delete(Map map) {
        return 0;
    }

    @Override
    public int getSuggestListCount() {
        return 0;
    }
}
