package com.project.myapp.login.dao;

import com.project.myapp.dto.UserDTO;

import java.util.Map;

public interface LoginDAO {

	public int loginCheck(Map<String, String> map);

	UserDTO passCheckById(String id);
}
