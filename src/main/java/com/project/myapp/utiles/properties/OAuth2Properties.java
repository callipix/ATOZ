package com.project.myapp.utiles.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;

import lombok.Builder;
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

	@Builder
	private ClientRegistration googleClientRegistration() {
		return CommonOAuth2Provider.GOOGLE.getBuilder("google")
			.clientId(google_client_id)
			.clientSecret(google_client_secret)
			.redirectUri(google_redirect_uri)
			.scope(scope)
			.build();
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		ClientRegistrationRepository clientRegistrationRepository = new InMemoryClientRegistrationRepository(
			googleClientRegistration());
		return clientRegistrationRepository;
	}
}