package com.project.myapp.security1.config;

import lombok.Getter;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:application-oauth.properties")
@Getter
public class SecurityProperties {

    @Value("${spring.security.oauth2.client.registration.google.client-id}")
    private String clientId;
    @Value("${spring.security.oauth2.client.registration.google.client-secret}")
    private String clientSecret;
    @Value("${spring.security.oauth2.client.registration.google.redirect-uri}")
    private String redirect_uri;
    @Value("${spring.security.oauth2.client.registration.google.authorization-grant-type}")
    private String authorization_grant_type;
    @Value("${spring.security.oauth2.client.registration.google.scope}")
    private String scope;

}
