package com.project.myapp.security.jwt.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.project.myapp.dto.RefreshDTO;

@Mapper
public interface RefreshMapper {

	boolean existsByRefreshToken(String refreshToken);

	int deleteByRefreshToken(String refreshToken);

	int insertSave(RefreshDTO refreshDTO);

}
