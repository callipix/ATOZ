package com.project.atoz.suggestion.dao;

import java.util.List;
import java.util.Map;

import com.project.atoz.dto.SuggestionDTO;

public interface SuggestionDAO {

	public List<SuggestionDTO> getSuggestList(Map map);

	public int insert(SuggestionDTO suggestionDTO);

	public int update(SuggestionDTO suggestionDTO);

	public int delete(Map map);

	public int getSuggestListCount();

	public int passCheck(int sno, String password);

}
