package com.project.myapp.security.oauth.service;

public interface OAuth2UserInfo {

	String getProviderId();

	String getProvider();

	String getEmail();

	String getName();
}
