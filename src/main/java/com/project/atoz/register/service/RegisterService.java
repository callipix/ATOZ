package com.project.atoz.register.service;

import com.project.atoz.dto.RegisterDTO;
import com.project.atoz.dto.UserDTO;

public interface RegisterService {

	int idCheck(String id);

	String sendSMS(String phoneNo);

	int insertUser(RegisterDTO registerDTO) throws Exception;

}
