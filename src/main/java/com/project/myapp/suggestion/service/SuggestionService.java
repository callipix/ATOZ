package com.project.myapp.suggestion.service;

import com.project.myapp.dto.SuggestionDTO;

import java.util.List;
import java.util.Map;

public interface SuggestionService {
    public List<SuggestionDTO> getSuggestList();

    public SuggestionDTO insert(SuggestionDTO suggestionDTO);

    public int update(SuggestionDTO suggestionDTO);

    public int delete(String password , int sno);

    public int getSuggestListCount();
}
