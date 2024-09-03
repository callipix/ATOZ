package com.project.myapp.register.dao;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.UserDTO;

public interface RegisterDAO {

	int idCheck(String id);

	int insertUser(UserDTO userDTO);

	int insertMember(MemberDTO memberDTO);

	UserDTO findByEmail(String email);

	UserDTO findById(String id);

	UserDTO findByProviderAndProviderId(String provider, String providerId);

	int save(UserDTO userDTO);
}