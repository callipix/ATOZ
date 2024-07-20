package com.project.myapp.register.service;

import com.project.myapp.dto.RegisterDTO;

public interface RegisterService {

    public int idCheck(String id);

    public String sendSMS(String phoneNo);

    public int insertUser(RegisterDTO registerDTO) throws Exception;
}
