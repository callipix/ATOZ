package com.project.myapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:application-jwt.properties")
public class JwtProperties {

	@Value("${spring.redis.host}")
	private String host;
	@Value("${spring.redis.port}")
	private int port;
	@Value("${spring.session.store-type}")
	private String sessionStoreType;
	@Value("${jwt.token.key}")
	private String jwtTokenKey;
}
