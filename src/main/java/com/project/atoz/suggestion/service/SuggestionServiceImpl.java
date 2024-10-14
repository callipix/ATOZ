package com.project.atoz.suggestion.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.atoz.dto.SuggestionDTO;
import com.project.atoz.suggestion.mapper.SuggestionMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class SuggestionServiceImpl implements SuggestionService {

	private final SuggestionMapper suggestionMapper;

	@Override
	public List<SuggestionDTO> getSelectPage(Map map) {
		List<SuggestionDTO> suggestionDTOList = this.suggestionMapper.getSelectPage(map);
		log.info("getSuggestList for serviceImpl");
		return suggestionDTOList;
	}

	@Override
	public SuggestionDTO suggestCommentInsert(SuggestionDTO suggestionDTO) {

		int result = this.suggestionMapper.suggestCommentInsert(suggestionDTO);
		log.info("insert from serviceImpl{}", result);
		log.info("suggestionDTO {}", suggestionDTO);
		return suggestionDTO;
	}

	@Override
	public int updateSuggestComment(SuggestionDTO suggestionDTO) {
		int result = this.suggestionMapper.updateSuggestComment(suggestionDTO);
		log.info("update from serviceImpl{}", result);
		log.info("suggestionDTO {}2", suggestionDTO);
		return result;
	}

	@Override
	public int suggestCommentDelete(String password, int sno) {
		Map<String, Object> map = new HashMap<>();
		map.put("password", password);
		map.put("sno", sno);
		int result = this.suggestionMapper.suggestCommentDelete(map);
		return result;
	}

	@Override
	public int suggestCommentCount() {
		int result = this.suggestionMapper.suggestCommentCount();
		log.info("getSuggestListCount from serviceImpl{}", result);
		return result;
	}

	@Override
	public int isEqualsIdNPass(int sno, String password) {
		int result = this.suggestionMapper.isEqualsIdNPass(sno, password);
		return result;
	}
}
