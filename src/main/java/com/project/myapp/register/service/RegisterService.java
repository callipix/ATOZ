package com.project.myapp.register.service;

import com.project.myapp.dto.RegisterDTO;

public interface RegisterService {

	int idCheck(String id);

	String sendSMS(String phoneNo);

	int insertUser(RegisterDTO registerDTO) throws Exception;
}
