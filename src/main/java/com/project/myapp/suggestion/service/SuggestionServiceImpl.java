package com.project.myapp.suggestion.service;

import com.project.myapp.dto.SuggestionDTO;
import com.project.myapp.suggestion.dao.SuggestionDAO;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
@AllArgsConstructor
public class SuggestionServiceImpl implements SuggestionService{

    private final SuggestionDAO suggestionDAO;

    @Override
    public List<SuggestionDTO> getSuggestList(Map map) {
        List<SuggestionDTO> suggestionDTOList = suggestionDAO.getSuggestList(map);
        return suggestionDTOList;
    }

    @Override
    public SuggestionDTO insert(SuggestionDTO suggestionDTO) {
        int result = this.suggestionDAO.insert(suggestionDTO);
        return suggestionDTO;
    }

    @Override
    public int update(SuggestionDTO suggestionDTO) {
        int result = this.suggestionDAO.update(suggestionDTO);
        return result;
    }

    @Override
    public int delete(String password , int sno) {
        Map<String , Object> map = new HashMap<>();
        map.put("password", password);
        map.put("sno", sno);
        int result = suggestionDAO.delete(map);
        return result;
    }

    @Override
    public int getSuggestListCount() {
        int result = suggestionDAO.getSuggestListCount();
        return result;
    }

    @Override
    public int passCheck(int sno, String password) {
        int result = suggestionDAO.passCheck(sno, password);
        return result;
    }
}