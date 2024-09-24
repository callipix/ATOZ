package com.project.atoz.security.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.CorsRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class CorsMvcConfig implements WebMvcConfigurer {

	@Override
	public void addCorsMappings(CorsRegistry corsRegistry) {

		corsRegistry.addMapping("/**")
			.allowedOrigins("http://localhost:8080")
			.allowedMethods("GET", "POST", "PUT", "DELETE") // 허용할 메서드
			.allowedHeaders("*") // 허용할 헤더
			.allowCredentials(true); // 인증 정보 허용 (쿠키 등)
	}
}