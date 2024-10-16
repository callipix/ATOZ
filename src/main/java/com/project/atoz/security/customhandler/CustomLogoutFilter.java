package com.project.atoz.security.customhandler;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.filter.GenericFilterBean;

import com.project.atoz.security.jwt.JwtUtil;
import com.project.atoz.security.jwt.mapper.RefreshMapper;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class CustomLogoutFilter extends GenericFilterBean {

	private final JwtUtil jwtUtil;
	private final RefreshMapper refreshMapper;

	@Override
	public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws
		IOException,
		ServletException {

		doFilter((HttpServletRequest)request, (HttpServletResponse)response, chain);
	}

	private void doFilter(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws
		IOException,
		ServletException {

		// path and method verify
		String requestUri = request.getRequestURI();
		log.info("requestUri = {}", requestUri);
		if (!requestUri.matches("^\\/logout$")) {
			log.info("logout 경로와 다르면 해당 필터 종료");
			filterChain.doFilter(request, response);
			return;
		}
		String requestMethod = request.getMethod();
		if (!requestMethod.equals("POST")) {
			filterChain.doFilter(request, response);
			return;
		}

		//get refresh token
		String refresh = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("refresh")) {

				refresh = cookie.getValue();
			}
		}

		// refresh null check
		if (refresh == null) {
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// expired check
		try {
			jwtUtil.isExpired(refresh);
		} catch (ExpiredJwtException e) {
			//response status code
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// 토큰이 refresh 인지 확인 (발급시 페이로드에 명시)
		String category = jwtUtil.getCategory(refresh);
		if (!category.equals("refresh")) {
			//response status code
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// DB에 저장 되어 있는지 확인
		Boolean isExist = refreshMapper.existsByRefreshToken(refresh);
		if (!isExist) {
			//response status code
			log.info("isExist 여기서 안뜨는듯 = {}");
			response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
			return;
		}

		// logout 진행
		// Refresh 토큰 DB 제거
		refreshMapper.deleteByRefreshToken(refresh);

		//Refresh 토큰 Cookie 제거
		Cookie cookie = new Cookie("refresh", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");

		response.addCookie(cookie);
		response.setStatus(HttpServletResponse.SC_OK);
	}
}
