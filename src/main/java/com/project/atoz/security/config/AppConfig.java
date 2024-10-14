package com.project.atoz.security.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.handler.HandlerMappingIntrospector;

@Configuration
public class AppConfig {
	@Bean(name = "mvcHandlerMappingIntrospector")
	public HandlerMappingIntrospector mvcHandlerMappingIntrospector() {
		return new HandlerMappingIntrospector();
	}

	/**
	 * 해당 빈을 별도 클래스 작성 없이 사용 하려면 @EnableWebMvc 어노테이션 사용
	 * HandlerMappingIntrospector : Spring MVCC 요청을 처리할 수 있는 핸들러를 찾기 위해 사용되는 유틸리티 클래스
	 * 여러 HandlerMapping 인스턴스들을 통해 어떤 요청이 어떤 핸들러에 의해 처리될 수 있는지 조사
	 *
	 * ** 핸들러의 역할
	 * 1. 핸들러 매핑 검사
	 * HandlerMappingIntrospector : 등록된 모든 HandlerMapping 조사하여 주어진 요청에 대해 적합한 핸들러를 검색
	 * ex) REST API 요청이 들어오면 요청 URI 일치하는 핸들러 메서드가 있는지 확인
	 *
	 * 2. MVC에서의 역할
	 * 보통 Spring MVCC(@Controller, @RequestMapping, @RestController 등)과 관련된 요청들을 처리하는 핸들러들을 찾아내는 데 사용
	 * 요청이 들어오면, DispatcherServlet은 여러 HandlerMapping(예: RequestMappingHandlerMapping, SimpleUrlHandlerMapping 등)을 통해 요청에 맞는 핸들러를 검색
	 * HandlerMappingIntrospector 이러한 핸들러 매핑을 쉽게 조회할 수 있도록 도와줌.
	 *
	 * 3. 보안 및 권한 검사
	 * Spring Security 함께 사용 시, 특정 요청이 어떤 핸들러에 의해 처리 될지 확인한 뒤 해당 핸들러에 대한 권한 및 인증 정보를 검토
	 * ex) 메서드 보안 검사를 위해 HandlerMappingIntrospector로 핸들러 메서드를 검사, 해당 메서드에 적용된 보안 관련 어노테이션 확인 가능
	 * -> 주로 Spring Security에서 mvcMatcher와 함께 사용되어 요청 URL과 핸들러를 일치시켜 보안 규칙을 적용할 때 사용
	 */
}