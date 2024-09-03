package com.project.myapp.register.service;

import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;

public interface RegisterService {

	int idCheck(String id);

	String sendSMS(String phoneNo);

	int insertUser(RegisterDTO registerDTO) throws Exception;

	UserDTO findByEmail(String email);

}
