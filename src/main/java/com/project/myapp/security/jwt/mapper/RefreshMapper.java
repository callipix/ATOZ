package com.project.myapp.security.jwt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.project.myapp.dto.RefreshDTO;

@Mapper
public interface RefreshMapper {

	boolean existsByRefreshToken(String refreshToken);

	@Transactional(rollbackFor = Exception.class)
	int deleteByRefreshToken(String refreshToken);

	@Transactional(rollbackFor = Exception.class)
	int insertSave(RefreshDTO refreshDTO);

}
