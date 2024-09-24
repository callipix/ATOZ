package com.project.atoz.suggestion.dao;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.atoz.dto.SuggestionDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class SuggestionDAOImpl implements SuggestionDAO {

	private final SqlSession sqlSession;
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
		log.info("passCheck DAOImpl sno = {}", sno);
		log.info("passCheck DAOImpl = {} ", password);
		Map<String, Object> map = new HashMap<>();
		map.put("sno", sno);
		map.put("password", password);
		log.info("passCheck DAOImpl map = {} ", map);
		int result = this.sqlSession.selectOne(namespace + "isEqualsIdNPass", map);
		log.info("passCheck DAOImpl result = {} ", result);
		return result;
	}
}
