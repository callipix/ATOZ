package com.project.atoz.login.service;

import com.project.atoz.dto.UserDTO;

public interface LoginService {

	public int loginCheck(String id, String password);

	public UserDTO passCheckById(String id);

}
