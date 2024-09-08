package com.project.myapp.security.oauth.service;

import java.util.Arrays;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum CustomOAuth2User {
	GOOGLE(null, "sub", "email");

	private final String attributeName;
	private final String provider;
	private final String identifier;

	public static CustomOAuth2User from(String provider) {
		String upperCastedProvider = provider.toUpperCase();

		return Arrays.stream(CustomOAuth2User.values())
			.filter(item -> item.name().equals(upperCastedProvider))
			.findFirst()
			.orElseThrow();
	}
}