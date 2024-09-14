package com.project.myapp.security.jwt;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

	private final JwtUtil jwtUtil;

	@Override
	protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
		FilterChain filterChain) throws ServletException, IOException {

		log.info("JwtFilter 시작");
		// cookie들을 불러온 뒤 Authorization key에 담긴 쿠키를 찾는다
		String authorization = null;
		Cookie[] cookies = request.getCookies();
		log.info("cookies = {}", cookies);

		if (cookies != null) {

			for (Cookie cookie : cookies) {
				log.info("cookie.getName() = {}", cookie.getName());
				if (cookie.getName().equals("Authorization")) {
					authorization = cookie.getValue();
				}
			}
		}
		if (authorization == null) {
			log.info("token is empty");
			filterChain.doFilter(request, response);
			// 메서드 종료
			return;
		}
		// 토큰
		String token = authorization;

		// 토큰 소멸 시간 검증
		if (jwtUtil.isExpired(token)) {
			log.info("token is expired");
			filterChain.doFilter(request, response);
			// 메서드 종료
			return;
		}

		// 토큰에서 username과 role 획득
		String username = jwtUtil.getUsername(token);
		String role = jwtUtil.getRole(token);

		// userDTO 생성하여 값 추가
		UserDTO userDTO = new UserDTO();
		userDTO.setId(username);
		userDTO.setRole(role);

		log.info("userDTO for jwtFilter = {}", userDTO);
		// userDetails에 회원 정보 객체 추가
		CustomDetails customDetails = new CustomDetails(userDTO);

		// 스프링 시큐리티 인증 토큰 생성
		Authentication authToken = new UsernamePasswordAuthenticationToken(customDetails, null,
			customDetails.getAuthorities());

		// 세션에 사용자 등록
		SecurityContextHolder.getContext().setAuthentication(authToken);
		filterChain.doFilter(request, response);
	}
	// @Override
	// protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response,
	// 	FilterChain filterChain) throws ServletException, IOException {
	//
	// 	log.info("어디가 먼저지?");
	// 	log.info("로그인 후 토큰 검증 확인");
	//
	// 	String accessToken = request.getHeader("access");
	// 	log.info("accessToken = {}", accessToken);
	//
	// 	if (accessToken == null) {
	// 		filterChain.doFilter(request, response);
	// 		return;
	// 	}
	// 	try {
	// 		jwtUtil.isExpired(accessToken);
	// 	} catch (ExpiredJwtException e) {
	// 		PrintWriter writer = response.getWriter();
	// 		writer.print("access token expired");
	// 		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	// 		return;
	// 	}
	//
	// 	String category = jwtUtil.getCategory(accessToken);
	//
	// 	if (!category.equals("access")) {
	//
	// 		PrintWriter writer = response.getWriter();
	// 		writer.print("invalid access token");
	// 		response.setStatus(HttpServletResponse.SC_UNAUTHORIZED);
	// 		return;
	// 	}
	//
	// 	String username = jwtUtil.getUsername(accessToken);
	// 	String role = jwtUtil.getRole(accessToken);
	//
	// 	UserDTO userDTO = new UserDTO();
	// 	userDTO.setId(username);
	// 	userDTO.setRole(role);
	//
	// 	log.info("userDTO = {}", userDTO);
	// 	log.info("token = {}", accessToken);
	//
	// 	// userDetails에 회원 정보 객체 추가
	// 	CustomDetails customDetails = new CustomDetails(userDTO);
	//
	// 	// 스프링 시큐리티 인증 토큰 생성
	// 	Authentication authToken = new UsernamePasswordAuthenticationToken(customDetails, null,
	// 		customDetails.getAuthorities());
	//
	// 	// 세션에 사용자 등록
	// 	SecurityContextHolder.getContext().setAuthentication(authToken);
	//
	// 	filterChain.doFilter(request, response);
	// }
}
