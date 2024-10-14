package com.project.atoz.security.auth;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.oauth2.core.user.OAuth2User;

import com.project.atoz.dto.UserDTO;

import lombok.Getter;

@Getter
@NoArgsConstructor
public class CustomDetails implements UserDetails, OAuth2User {

	private UserDTO user;
	private Map<String, Object> attributes;

	public CustomDetails(UserDTO user){
		this.user = user;
    }

	// OAuth2.0 로그인 시 사용
	public CustomDetails(UserDTO user, Map<String, Object> attributes){
		this.user = user;
		this.attributes = attributes;
    }

	public UserDTO getUser() {
		return user;
	}

	@Override
	public Map<String, Object> getAttributes() {
		return attributes;
	}

	// 해당 User 권한 리턴 메서드
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
		return true;
	}

	@Override
	public String getName() {
		return user.getId()+"";
	}

}
