package com.project.myapp.security.config;

import java.util.Arrays;
import java.util.List;

import com.project.myapp.security.JwtAuthenticationFilter;
import com.project.myapp.security.JwtTokenProvider;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.Environment;
import org.springframework.security.config.annotation.method.configuration.EnableGlobalMethodSecurity;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.oauth2.client.CommonOAuth2Provider;
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
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import com.project.myapp.security.oauth.service.CustomOAuth2UserService;
import com.project.myapp.utiles.properties.OAuth2Properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@EnableWebMvc
@Configuration
@EnableWebSecurity    // 부트와 달리 일반스프링에서는 @EnableWebSecurity 어노테이션 추가해도 web.xml에 반드시 필터 추가 해줘야 작동한다.
@RequiredArgsConstructor
@PropertySource("classpath:application-oauth2.properties")
@EnableGlobalMethodSecurity(securedEnabled = true, prePostEnabled = true)
@ComponentScan(basePackages = {"com.project.myapp", "com.project.myapp.security.auth", "com.project.myapp"})
public class SecurityConfig {

	private final OAuth2Properties oAuth2Properties;
	private final CustomOAuth2UserService customOAuth2UserService;
	private static List<String> clients = Arrays.asList("google");

	@Bean
	public DefaultWebSecurityExpressionHandler webSecurityExpressionHandler() {
		return new DefaultWebSecurityExpressionHandler();
	}

	@Bean
	public BCryptPasswordEncoder bCryptPasswordEncoder() {
		return new BCryptPasswordEncoder();
	}

	@Bean
	public SecurityFilterChain filterChain(HttpSecurity http, JwtTokenProvider jwtTokenProvider) throws Exception {
		http.csrf(AbstractHttpConfigurer::disable)
			.authorizeHttpRequests(authorize -> authorize
				.requestMatchers("/user/**").authenticated()
				.requestMatchers("/manager/**").hasAnyRole("MANAGER", "ADMIN")
				.requestMatchers("/admin/**").hasRole("ADMIN")
				.anyRequest().permitAll()
			);

		http.formLogin()
			.loginPage("/login/loginForm")        // 실제 로그인 폼페이지
			.loginProcessingUrl("/login/login") // 실제 로그인 처리경로
			.usernameParameter("id")
			.passwordParameter("password")
			.defaultSuccessUrl("/");

		http.oauth2Login()
			.clientRegistrationRepository(clientRegistrationRepository())
			.userInfoEndpoint()
			.userService(customOAuth2UserService);
		http.addFilterBefore(new JwtAuthenticationFilter(jwtTokenProvider) , UsernamePasswordAuthenticationFilter.class);

		http.exceptionHandling().authenticationEntryPoint(new CustomAuthenticationEntryPoint());
		http.exceptionHandling().accessDeniedHandler(new CustomAccessDeniedHandler());

		http.logout()
			.logoutUrl("/login/logout")
			.logoutSuccessUrl("/")
			.invalidateHttpSession(true)
			.deleteCookies("SESSION")
			.deleteCookies("JSESSIONID")
			.permitAll();

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
			.redirectUri(oAuth2Properties.getGoogle_redirect_url())
			.authorizationUri("https://accounts.google.com/o/oauth2/auth")
			.tokenUri("https://oauth2.googleapis.com/token")
			.userInfoUri("https://www.googleapis.com/oauth2/v3/userinfo")
			.build();

		return new InMemoryClientRegistrationRepository(googleClientRegistration);

	}

	@Bean
	public OAuth2AuthorizedClientService authorizedClientService() {
		return new InMemoryOAuth2AuthorizedClientService(oAuth2Properties.clientRegistrationRepository());
	}

	private static String CLIENT_PROPERTY_KEY
		= "spring.security.oauth2.client.registration.";

	private final Environment env;

	private ClientRegistration getRegistration(String client) {
		String clientId = env.getProperty(
			CLIENT_PROPERTY_KEY + client + ".client-id");

		if (clientId == null) {
			return null;
		}
		String clientSecret = env.getProperty(
			CLIENT_PROPERTY_KEY + client + ".client-secret");

		if (client.equals("google")) {
			return CommonOAuth2Provider.GOOGLE.getBuilder(client)
				.clientId(clientId).clientSecret(clientSecret).build();
		}
		if (client.equals("facebook")) {
			return CommonOAuth2Provider.FACEBOOK.getBuilder(client)
				.clientId(clientId).clientSecret(clientSecret).build();
		}
		return null;
	}
}