package com.project.myapp.utiles;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource("classpath:api-config.properties")
public class ApiConfigProperties {

	@Value("${api_key}")
	private String apiKey;
	@Value("${api_secret}")
	private String apiSecret;

	public String getApiKey() {
		return apiKey;
	}

	;

	public String getApiSecret() {
		return apiSecret;
	}

	;
}
