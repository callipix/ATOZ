package com.project.myapp.security.customhandler;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.security.auth.CustomDetails;
import com.project.myapp.security.jwt.JwtUtil;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		log.info("로그인 후 토큰 검증 확인");

		// String Authorization = request.getHeader("Authorization");
		String accessToken = request.getHeader("access");

		// log.info("Authorization = {}", Authorization);
		log.info("accessToken for 1 = {}", accessToken);

		if (accessToken == null) {
			filterChain.doFilter(request, response);
			return;
		}
		log.info("accessToken for 2 = {}", accessToken);

		try {
			jwtUtil.isExpired(accessToken);
		} catch (ExpiredJwtException e) {
			PrintWriter writer = response.getWriter();
			writer.print("access token expired");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		String category = jwtUtil.getCategory(accessToken);

		if (!category.equals("access")) {
			PrintWriter writer = response.getWriter();
			writer.print("invalid access token");
			response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
			return;
		}

		String username = jwtUtil.getUsername(accessToken);
		String role = jwtUtil.getRole(accessToken);

		UserDTO userDTO = new UserDTO();
		userDTO.setId(username);
		userDTO.setRole(role);

		log.info("userDTO = {}", userDTO);
		log.info("token = {}", accessToken);

		// userDetails에 회원 정보 객체 추가
		CustomDetails customDetails = new CustomDetails(userDTO);

		// 스프링 시큐리티 인증 토큰 생성
		Authentication authToken = new UsernamePasswordAuthenticationToken(customDetails, null,
			customDetails.getAuthorities());

		// 세션에 사용자 등록
		SecurityContextHolder.getContext().setAuthentication(authToken);

		log.info("authToken 다 됐으면 여기서 객체 생성 해야하는데? = {}", authToken);
		filterChain.doFilter(request, response);
	}
}
