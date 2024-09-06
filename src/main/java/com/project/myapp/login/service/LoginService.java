package com.project.myapp.login.service;

import com.project.myapp.dto.UserDTO;

public interface LoginService {

	public int loginCheck(String id, String password);

	public UserDTO passCheckById(String id);

}
