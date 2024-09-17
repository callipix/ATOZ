package com.project.myapp.security.auth;

import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.register.dao.RegisterMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

// login 요청이 오면 자동으로 UserDetailsService 타입으로 IoC 되어있는 loadUserByUsername 함수가 실행
@Slf4j
@Service
@RequiredArgsConstructor
public class CustomDetailsService implements UserDetailsService {

	private final RegisterMapper registerMapper;

	// Security Session(내부 Authentication(내부 UserDetails))
	@Override
	public UserDetails loadUserByUsername(String id) throws UsernameNotFoundException {
		log.info("username = {}", id);
		log.info("여기 타는거 맞지?");

		UserDTO userEntity = registerMapper.findById(id);

		log.info("userEntity = {}", userEntity);
		if (userEntity != null) {
			return new CustomDetails(userEntity);
		}
		return null;
	}
}