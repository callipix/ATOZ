package com.project.myapp.suggestion.service;

import com.project.myapp.dto.SuggestionDTO;
import com.project.myapp.suggestion.dao.SuggestionDAO;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService{

    private final SuggestionDAO suggestionDAO;

    @Override
    public List<SuggestionDTO> getSuggestList(Map map) {
        List<SuggestionDTO> suggestionDTOList = suggestionDAO.getSuggestList(map);
        log.info("getSuggestList for serviceImpl");
        return suggestionDTOList;
    }

    @Override
    public SuggestionDTO insert(SuggestionDTO suggestionDTO) {

        int result = this.suggestionDAO.insert(suggestionDTO);
        log.info("insert for serviceImpl{}", result);
        log.info("suggestionDTO {}", suggestionDTO);
        return suggestionDTO;
    }

    @Override
    public int update(SuggestionDTO suggestionDTO) {
        int result = this.suggestionDAO.update(suggestionDTO);
        log.info("update for serviceImpl{}", result);
        log.info("suggestionDTO {}2", suggestionDTO);
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
        log.info("getSuggestListCount for serviceImpl{}" , result);
        return result;
    }

    @Override
    public int passCheck(int sno, String password) {
        int result = suggestionDAO.passCheck(sno, password);
        return result;
    }
}
