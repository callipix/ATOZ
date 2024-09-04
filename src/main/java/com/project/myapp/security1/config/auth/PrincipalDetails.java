package com.project.myapp.security1.config.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import com.project.myapp.dto.UserDTO;

@Getter
@RequiredArgsConstructor
public class PrincipalDetails implements UserDetails {

	private final UserDTO user;  // 컴포지션
	private Map<String, Object> attributes;

	// 해당 User의 권한을 리턴하는 메서드
	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		Collection<GrantedAuthority> collect = new ArrayList<>();
		collect.add((GrantedAuthority)() -> user.getRole());

		return collect;
	}

	@Override
	public String getPassword() {
		return user.getPassword();
	}

	@Override
	public String getUsername() {
		return user.getNickName();
	}

	@Override
	public boolean isAccountNonExpired() {
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		return true;
	}

	@Override
	public boolean isEnabled() {
		// 우리 사이트에서 1년동안 회원이 로그인을 하지않으면 휴면 계정으로 전환하기로 함!
		// 현재시간 - 로그인 시간 => 1년 초과시 return false;
		return true;
	}
}
