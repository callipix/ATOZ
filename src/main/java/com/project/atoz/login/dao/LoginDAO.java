package com.project.atoz.login.dao;

import com.project.atoz.dto.UserDTO;

import java.util.Map;

public interface LoginDAO {

	public int loginCheck(Map<String, String> map);

	UserDTO passCheckById(String id);
}
