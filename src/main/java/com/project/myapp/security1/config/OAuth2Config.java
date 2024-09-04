//package com.project.myapp.security1.config;
//
//
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//
//@Configuration
//@PropertySource("classpath:application-oauth.properties")
//public class OAuth2Config {
//
//    private SecurityProperties securityProperties;
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration googleClientRegistration = ClientRegistration.withRegistrationId("google")
//                .clientId(securityProperties.getClientId())
//                .clientSecret(securityProperties.getClientSecret())
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri(securityProperties.getRedirect_uri())
//                .scope(securityProperties.getScope().split(","))
//                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
//                .tokenUri("https://oauth2.googleapis.com/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .build();
//
//        return new InMemoryClientRegistrationRepository(googleClientRegistration);
//    }
//}
