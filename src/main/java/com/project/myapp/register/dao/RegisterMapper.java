package com.project.myapp.register.dao;

import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.UserAuth;
import com.project.myapp.dto.UserDTO;

@Mapper
public interface RegisterMapper {

	int idCheck(String id);

	int insertUser(UserDTO userDTO);

	int insertAuth(UserAuth userAuth);

	int insertMember(MemberDTO memberDTO);

	UserDTO findByEmail(String email);

	UserDTO findById(String id);

	Optional<UserDTO> findByProviderAndProviderId(String provider, String providerId);

	int save(UserDTO userDTO);

	int updateUser(UserDTO userDTO);
}