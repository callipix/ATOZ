package com.project.myapp.suggestion.dao;

import com.project.myapp.dto.SuggestionDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Map;

public interface SuggestionDAO {

    public List<SuggestionDTO> getSuggestList();

    public int insert(SuggestionDTO suggestionDTO);

    public int update(SuggestionDTO suggestionDTO);

    public int delete(Map map);

    public int getSuggestListCount();

    public int passCheck(int sno , String password);

}
