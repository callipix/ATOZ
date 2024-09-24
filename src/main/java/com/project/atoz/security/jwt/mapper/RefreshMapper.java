package com.project.atoz.security.jwt.mapper;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.transaction.annotation.Transactional;

import com.project.atoz.dto.RefreshDTO;

@Mapper
public interface RefreshMapper {

	boolean existsByRefreshToken(String refreshToken);

	@Transactional(rollbackFor = Exception.class)
	int deleteByRefreshToken(String refreshToken);

	@Transactional(rollbackFor = Exception.class)
	int insertSave(RefreshDTO refreshDTO);

}
