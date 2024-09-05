package com.project.myapp.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.project.myapp.dto.UserDTO;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public class CustomDetails implements UserDetails, OAuth2User {

	private UserDTO user;  // 컴포지션
	private Map<String, Object> attributes;

	public CustomDetails(UserDTO user) {
		this.user = user;
	}

	// OAuth2.0 로그인시 사용
	public CustomDetails(UserDTO user, Map<String, Object> attributes) {
		this.user = user;
		this.attributes = attributes;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return Map.of();
	}

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

	@Override
	public String getName() {
		return "";
	}
}
