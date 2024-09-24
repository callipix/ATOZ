package com.project.atoz.login.dao;

import java.util.Map;

import com.project.atoz.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Repository
@RequiredArgsConstructor
public class LoginDAOImpl implements LoginDAO {

	private final SqlSession sqlSession;
	private static final String namespace = "com.project.myapp.login.dao.LoginMapper.";

	@Override
	public int loginCheck(Map<String, String> map) {
		int result = 0;
		log.info("map = {}", map);
		result = sqlSession.selectOne(namespace + "loginCheck", map);
		log.info("loginCheck result = {}", result);
		return result;
	}

	@Override
	public UserDTO passCheckById(String id) {
		UserDTO result = sqlSession.selectOne(namespace + "passCheckById", id);
		log.info("passCheckById result = {}", result);
		return result;
	}
}
