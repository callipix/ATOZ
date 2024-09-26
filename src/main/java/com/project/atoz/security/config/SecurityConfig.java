package com.project.atoz.security.config;

import java.util.Collections;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.config.annotation.authentication.configuration.AuthenticationConfiguration;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
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
import org.springframework.security.oauth2.core.AuthorizationGrantType;
import org.springframework.security.oauth2.core.endpoint.OAuth2AuthorizationRequest;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.access.expression.DefaultWebSecurityExpressionHandler;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.security.web.authentication.logout.LogoutFilter;
import org.springframework.web.cors.CorsConfiguration;
import org.springframework.web.cors.UrlBasedCorsConfigurationSource;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.atoz.properties.OAuth2Properties;
import com.project.atoz.security.customhandler.CustomLogoutFilter;
import com.project.atoz.security.customhandler.CustomSuccessHandler;
import com.project.atoz.security.customhandler.JwtFilter;
import com.project.atoz.security.customhandler.LoginFilter;
import com.project.atoz.security.jwt.JwtUtil;
import com.project.atoz.security.jwt.mapper.RefreshMapper;
import com.project.atoz.security.oauth.service.CustomOAuth2UserService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@Configuration
@EnableWebSecurity    // non-Boot 에서는 @EnableWebSecurity 어노테이션 추가해도 web.xml에 반드시 필터 추가 해줘야 작동한다.
@RequiredArgsConstructor
@MapperScan("com.project.atoz.security.jwt.mapper")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan(basePackages = {"com.project.atoz", "com.project.atoz.security.**"})
public class SecurityConfig {

	private final JwtUtil jwtUtil;
	private final RefreshMapper refreshMapper;
	private final OAuth2Properties oAuth2Properties;
	private final CustomSuccessHandler customSuccessHandler;
	private final CustomOAuth2UserService customOAuth2UserService;
	private final AuthenticationConfiguration authenticationConfiguration;

	@Bean
	public AuthenticationManager authenticationManager(AuthenticationConfiguration configuration) throws Exception {
		return configuration.getAuthenticationManager();
	}

	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}

	@Bean
	public static BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {

		/** CORS 설정 시작 */
		CorsConfiguration configuration = new CorsConfiguration();
		configuration.setAllowedOrigins(Collections.singletonList("http://localhost:8080/*"));
		configuration.setAllowedHeaders(Collections.singletonList("*"));
		configuration.setAllowedMethods(Collections.singletonList("*"));
		configuration.setExposedHeaders(Collections.singletonList("access"));
		configuration.setAllowCredentials(true);
		configuration.setMaxAge(3600L);

		UrlBasedCorsConfigurationSource source = new UrlBasedCorsConfigurationSource();
		source.registerCorsConfiguration("/**", configuration);
		http.cors().configurationSource(source);
		/** CORS 설정 끝 */

		/** CSRF 설정 : 비활성화 */
		http.csrf(AbstractHttpConfigurer::disable);

		/** 폼 로그인 : 비활성화 */
		http.formLogin().disable();

		/** HTTP Basic 인증 : 비활성화(기존 : 요청 헤더에 사용자명 + 비밀번호 포함 인증) */
		http.httpBasic().disable();

		/** 특정 URL에 대한 접근 권한 설정 */
		http.authorizeHttpRequests((auth) -> auth
			.requestMatchers("/js/**").permitAll()
			.requestMatchers("/css/**").permitAll()
			.requestMatchers("/img/**").permitAll()
			.requestMatchers("/ckeditor5/**").permitAll()
			.requestMatchers("/bootstrap/**").permitAll()
			.requestMatchers("/jwtLogin").permitAll()
			.requestMatchers("/reissue").permitAll()
			.requestMatchers("/suggestions/**").permitAll()
			.requestMatchers("/login/loginForm").permitAll()
			.requestMatchers("/login").authenticated()
			.requestMatchers("/**").permitAll()
			// .requestMatchers("/**").permitAll() 이 코드 제거하니까 무한 리디렉션 뜬다?
			.anyRequest().authenticated()
		);

		/** 로그인 관련 필터 설정 시작 */
		http.addFilterBefore(
			new LoginFilter(authenticationManager(authenticationConfiguration), refreshMapper, jwtUtil),
			UsernamePasswordAuthenticationFilter.class);
		http.addFilterAfter(new JwtFilter(jwtUtil), LoginFilter.class);
		http.addFilterBefore(new JwtFilter(jwtUtil), UsernamePasswordAuthenticationFilter.class);
		http.addFilterBefore(new CustomLogoutFilter(jwtUtil, refreshMapper), LogoutFilter.class);
		/** 로그인 관련 필터 설정 끝 */

		/** OAuth2 인증 설정 시작 */
		http.oauth2Login((oauth2) -> oauth2
			.userInfoEndpoint((userInfoEndpointConfig) -> userInfoEndpointConfig
				.userService(customOAuth2UserService))
			.successHandler(customSuccessHandler)
			.clientRegistrationRepository(clientRegistrationRepository())
		);
		/** OAuth2 인증 설정 끝 */

		/** session 정책 설정 : stateless */
		http.sessionManagement((session) -> session
			.sessionCreationPolicy(SessionCreationPolicy.STATELESS));

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

		ClientRegistration googleClientRegistration = ClientRegistration.withRegistrationId("google")
			.clientId(oAuth2Properties.getGoogle_client_id())
			.clientSecret(oAuth2Properties.getGoogle_client_secret())
			.scope(oAuth2Properties.getScope())
			.authorizationGrantType(AuthorizationGrantType.AUTHORIZATION_CODE)
			.redirectUri(oAuth2Properties.getGoogle_redirect_uri())
			.authorizationUri("https://accounts.google.com/o/oauth2/v2/auth")
			.tokenUri("https://www.googleapis.com/oauth2/v4/token")
			.jwkSetUri("https://www.googleapis.com/oauth2/v3/certs")
			.userNameAttributeName("sub")
			.issuerUri("https://accounts.google.com")
			.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
			.clientName("Google")
			.build();

		return new InMemoryClientRegistrationRepository(googleClientRegistration);

	}

	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(clientRegistrationRepository());
	}
}