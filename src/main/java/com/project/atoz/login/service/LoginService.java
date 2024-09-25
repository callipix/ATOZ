package com.project.atoz.login.service;

import com.project.atoz.dto.UserDTO;

public interface LoginService {

	int loginCheck(String id, String password);

	UserDTO passCheckById(String id);

}
