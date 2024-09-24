package com.project.atoz.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:application-jwt.properties")
public class JwtProperties {

	@Value("${jwt.token.key}")
	private String jwtTokenKey;
}
