package com.project.myapp.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:api-config.properties")
public class ApiProperties {

	@Value("${api_key}")
	private String apiKey;
	@Value("${api_secret}")
	private String apiSecret;

}
