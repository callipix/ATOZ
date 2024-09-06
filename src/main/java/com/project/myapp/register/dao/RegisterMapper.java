package com.project.myapp.register.dao;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.UserAuth;
import com.project.myapp.dto.UserDTO;
import org.apache.ibatis.annotations.Mapper;

import java.util.Optional;

@Mapper
public interface RegisterMapper {

	int idCheck(String id);

	int insertUser(UserDTO userDTO);

	int insertAuth(UserAuth userAuth);

	int insertMember(MemberDTO memberDTO);

	UserDTO findByEmail(String email);

	UserDTO findById(String id);

	Optional<UserDTO> findByProviderAndProviderId(String provider, String providerId);

	int updateUser(UserDTO userDTO);
}