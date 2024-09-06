package com.project.myapp.security.config;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

import com.project.myapp.oauth.handler.OAuth2LoginFailureHandler;
import com.project.myapp.oauth.handler.OAuth2LoginSuccessHandler;
import com.project.myapp.security.auth.CustomDetailsService;
import com.project.myapp.security.handler.CustomAuthenticationSuccessHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.InMemoryOAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.OAuth2AuthorizedClientService;
import org.springframework.security.oauth2.client.endpoint.DefaultAuthorizationCodeTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AccessTokenResponseClient;
import org.springframework.security.oauth2.client.endpoint.OAuth2AuthorizationCodeGrantRequest;
import org.springframework.security.oauth2.client.registration.ClientRegistration;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.security.oauth2.client.registration.InMemoryClientRegistrationRepository;
import org.springframework.security.oauth2.client.web.AuthorizationRequestRepository;
import org.springframework.security.oauth2.client.web.HttpSessionOAuth2AuthorizationRequestRepository;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.myapp.oauth.CustomOAuth2UserService;
import com.project.myapp.utiles.properties.OAuth2Properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc        //
@Configuration        // 환경설정 선언
@EnableWebSecurity    //부트와 달리 일반스프링에서는 @EnableWebSecurity 어노테이션 추가해도 web.xml에 반드시 필터 추가 해줘야 작동한다.
@RequiredArgsConstructor
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan(basePackages = {"com.project.myapp" , "com.project.myapp.security.auth"})
public class SecurityConfig {

//	private final OAuth2LoginSuccessHandler oAuth2LoginSuccessHandler;
//	private final OAuth2LoginFailureHandler oAuth2LoginFailureHandler;
	private final CustomDetailsService customDetailsService;
	private final OAuth2Properties oAuth2Properties;
	private final CustomOAuth2UserService customOAuth2UserService;
	// additional configuration for non-Spring Boot projects
	private static List<String> clients = Arrays.asList("google");

	@Bean
	public BCryptPasswordEncoder encodePwd() {
		return new BCryptPasswordEncoder();
	}
	@Bean
	public UserDetailsService customUserDetailsService() {
		return customDetailsService;
	}
	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
				.authorizeHttpRequests(authorize -> authorize
						.requestMatchers("/user/**").authenticated()
						.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
						.requestMatchers("/admin/**").hasRole("ADMIN")
						.anyRequest().permitAll()
				);
		http.userDetailsService(customDetailsService);
		http.formLogin(form -> form
						.loginPage("/login/loginForm")		// 실제 로그인 폼페이지
						.loginProcessingUrl("/login/login") // 실제 로그인 처리경로
						.usernameParameter("id")
						.passwordParameter("password")
						.defaultSuccessUrl("/")
						.successHandler(new CustomAuthenticationSuccessHandler())
				)
				.oauth2Login(oauth2Login -> oauth2Login
						.loginPage("/login/loginForm") // 이 부분을 유지하고자 한다면, 커스텀 페이지 사용
//						.successHandler(oAuth2LoginSuccessHandler)	//  OAuth2 로그인 성공시 실행할 클래스
//						.failureHandler(oAuth2LoginFailureHandler)	//  OAuth2 로그인 실패시 실행할 클래스
						.userInfoEndpoint(userInfoEndpoint -> userInfoEndpoint.userService(customOAuth2UserService)))
		//	Spring에서 OAuth2 라이브러리를 통해 OAuth2 로그인이 완료되어 소셜 사용자의 정보를 받아왔을때 이를 어디서 처리할지 명시
		;
//		http.addFilterAfter(CusomJsonFilter(), LogoutFilter.class);
		return http.build();
	}

	@Bean
	public AuthorizationRequestRepository<OAuth2AuthorizationRequest> authorizationRequestRepository() {
		return new HttpSessionOAuth2AuthorizationRequestRepository();
	}

	@Bean
	public OAuth2AccessTokenResponseClient<OAuth2AuthorizationCodeGrantRequest> accessTokenResponseClient() {
		DefaultAuthorizationCodeTokenResponseClient accessTokenResponseClient = new DefaultAuthorizationCodeTokenResponseClient();
		return accessTokenResponseClient;
	}

	@Bean
	public ClientRegistrationRepository clientRegistrationRepository() {
		List<ClientRegistration> registrations = clients.stream()
				.map(c -> getRegistration(c))
				.filter(registration -> registration != null)
				.collect(Collectors.toList());

		return new InMemoryClientRegistrationRepository(registrations);
	}

	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}

	private ClientRegistration getRegistration(String client) {
		log.info("oAuth2Properties = {}", oAuth2Properties.getClientId());
		String clientId = oAuth2Properties.getClientId();

		if (clientId == null) {
			return null;
		}
		String clientSecret = oAuth2Properties.getClientSecret();

		if (client.equals("google")) {
			return CommonOAuth2Provider.GOOGLE.getBuilder(client)
					.clientId(clientId)
					.clientSecret(clientSecret)
					.build();
		}
		return null;
	}

}