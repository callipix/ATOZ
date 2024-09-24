package com.project.atoz.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:application-oauth2.properties")
public class OAuth2Properties {

	@Value("${spring.security.oauth2.client.registration.google.client-id}")
	private String google_client_id;

	@Value("${spring.security.oauth2.client.registration.google.client-secret}")
	private String google_client_secret;

	@Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
	private String google_redirect_uri;

	@Value("${spring.security.oauth2.client.registration.google.scope}")
	private String scope;
	
}