package com.project.atoz.suggestion.service;

import java.util.List;
import java.util.Map;

import com.project.atoz.dto.SuggestionDTO;

public interface SuggestionService {
	public List<SuggestionDTO> getSuggestList(Map map);

	public SuggestionDTO insert(SuggestionDTO suggestionDTO);

	public int update(SuggestionDTO suggestionDTO);

	public int delete(String password, int sno);

	public int getSuggestListCount();

	public int passCheck(int sno, String password);
}
