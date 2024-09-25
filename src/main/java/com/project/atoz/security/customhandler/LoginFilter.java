package com.project.atoz.security.customhandler;

import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.util.Collection;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletInputStream;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.http.HttpStatus;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;
import org.springframework.util.StreamUtils;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.atoz.dto.RefreshDTO;
import com.project.atoz.security.auth.CustomDetails;
import com.project.atoz.security.jwt.JwtUtil;
import com.project.atoz.security.jwt.mapper.RefreshMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
@MapperScan("com.project.atoz.security.jwt.mapper")
public class LoginFilter extends UsernamePasswordAuthenticationFilter {

	private final AuthenticationManager authenticationManager;
	private final RefreshMapper refreshMapper;
	private final JwtUtil jwtUtil;

	@Override
	public Authentication attemptAuthentication(HttpServletRequest req, HttpServletResponse res) throws
		AuthenticationException {

		log.info("일반 로그인 여길 타야 하는데?");

		Map<String, String> login;

		try {
			ObjectMapper objectMapper = new ObjectMapper();
			ServletInputStream inputStream = req.getInputStream();
			String messageBody = StreamUtils.copyToString(inputStream, StandardCharsets.UTF_8);
			login = objectMapper.readValue(messageBody, HashMap.class);

		} catch (IOException e) {
			throw new RuntimeException(e);
		}

		String username = login.get("username");
		String password = login.get("password");

		UsernamePasswordAuthenticationToken authToken = new UsernamePasswordAuthenticationToken(username, password,
			null);
		log.info("attemptAuthentication from attemptAuthentication.LoginFilter.class {} =", authToken);
		return authenticationManager.authenticate(authToken);
	}

	@Override
	protected void successfulAuthentication(HttpServletRequest request, HttpServletResponse response, FilterChain chain,
		Authentication authentication) throws IOException, ServletException {

		CustomDetails userDetails = (CustomDetails)authentication.getPrincipal();
		log.info("userDetails from successfulAuthentication.LoginFilter.class = {}", userDetails);

		String username = userDetails.getUsername();
		log.info("username from successfulAuthentication.LoginFilter.class = {}", username);

		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
		GrantedAuthority auth = iterator.next();

		String role = auth.getAuthority();
		String access = jwtUtil.createJwt("access", username, role, 6000000L);
		String refresh = jwtUtil.createJwt("refresh", username, role, 86400000L);

		addRefreshToken(username, refresh, 86400000L);

		log.info("access from successfulAuthentication.LoginFilter.class = {}", access);
		response.setHeader("access", access);
		response.addCookie(createCookie("refresh", refresh));
		response.setStatus(HttpStatus.OK.value(), response.getHeader("access"));

	}

	@Override
	protected void unsuccessfulAuthentication(HttpServletRequest request, HttpServletResponse response,
		AuthenticationException failed) throws IOException, ServletException {

		response.setStatus(401);
	}

	private Cookie createCookie(String key, String value) {
		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(60 * 60 * 60);
		cookie.setPath("/");
		cookie.setHttpOnly(true);

		return cookie;
	}

	private void addRefreshToken(String username, String refresh, Long expiredMs) {
		Date dateByGeneralLogin = new Date(System.currentTimeMillis() + expiredMs);
		int result = 0;

		RefreshDTO refreshDTO = new RefreshDTO();
		refreshDTO.setRefresh(refresh);
		refreshDTO.setUsername(username);
		refreshDTO.setExpiration(dateByGeneralLogin.toString());

		log.info("refreshDTO from addRefreshToken.LoginFilter.class = {}", refreshDTO);
		result += this.refreshMapper.insertSave(refreshDTO);
		log.info("result from addRefreshToken.LoginFilter.class = {}", result);

	}
}
