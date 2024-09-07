//package com.project.myapp.security1.config;
//
//
//import com.project.myapp.utiles.properties.OAuth2Properties;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.annotation.PropertySource;
//import org.springframework.security.oauth2.client.registration.ClientRegistration;
//import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
//import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
//import org.springframework.security.oauth2.core.AuthorizationGrantType;
//
//@Configuration
//@PropertySource("classpath:application-oauth2.properties")
//public class OAuth2Config {
//
//    private OAuth2Properties oAuth2Properties;
//
//    @Bean
//    public ClientRegistrationRepository clientRegistrationRepository() {
//        ClientRegistration googleClientRegistration = ClientRegistration.withRegistrationId("google")
//                .clientId(oAuth2Properties.getClientId())
//                .clientSecret(oAuth2Properties.getClientSecret())
//                .authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
//                .redirectUri(oAuth2Properties.getRedirect_uri())
//                .scope(oAuth2Properties.getScope().split(","))
//                .authorizationUri("https://accounts.google.com/o/oauth2/auth")
//                .tokenUri("https://oauth2.googleapis.com/token")
//                .userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
//                .build();
//
//        return new InMemoryClientRegistrationRepository(googleClientRegistration);
//    }
//}
