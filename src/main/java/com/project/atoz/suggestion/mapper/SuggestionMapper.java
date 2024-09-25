package com.project.atoz.suggestion.mapper;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;

import com.project.atoz.dto.SuggestionDTO;

@Mapper
public interface SuggestionMapper {

	List<SuggestionDTO> getSelectPage(Map map);

	int suggestCommentInsert(SuggestionDTO suggestionDTO);

	int updateSuggestComment(SuggestionDTO suggestionDTO);

	int suggestCommentDelete(Map map);

	int suggestCommentCount();

	int isEqualsIdNPass(int sno, String password);

}
