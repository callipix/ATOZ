package com.project.myapp.login.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Service;

import com.project.myapp.login.dao.LoginDAO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class LoginServiceImpl implements LoginService {

	private final LoginDAO loginDAO;

	@Override
	public int loginCheck(String id, String password) {

		log.info("id = {}", id);
		log.info("password = {}", password);

		int result = 0;
		Map<String, String> loginCheckMap = new HashMap<String, String>();
		loginCheckMap.put("id", id);
		loginCheckMap.put("password", password);

		log.info("loginCheckMap = {}", loginCheckMap);

		try {
			result = loginDAO.loginCheck(loginCheckMap);
			log.info("result = {}", result);

		} catch (Exception e) {
			e.printStackTrace();
			return 0;
		}
		return result;
	}
}