package com.project.atoz.register.dao;

import java.util.Map;
import java.util.Optional;

import org.apache.ibatis.annotations.Mapper;

import com.project.atoz.dto.MemberDTO;
import com.project.atoz.dto.UserAuth;
import com.project.atoz.dto.UserDTO;

@Mapper
public interface RegisterMapper {

	int idCheck(String id);

	int insertUser(UserDTO userDTO);

	int insertAuth(UserAuth userAuth);

	int insertMember(MemberDTO memberDTO);

	UserDTO findByEmail(String email);

	UserDTO findById(String id);

	Optional<UserDTO> findByProviderAndProviderId(Map<String,String> providerMap);

	int save(UserDTO userDTO);

	int updateUser(UserDTO userDTO);
}