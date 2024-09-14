package com.project.myapp.security;

import lombok.Getter;

@Getter
public enum UserRoleEnum {
	ROLE_ADMIN("관리자"), ROLE_USER("사용자");

	private String description;

	UserRoleEnum(String description) {
		this.description = description;
	}
}
