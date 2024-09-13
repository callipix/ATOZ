// package com.project.myapp.security.jwt;
//
// import java.io.IOException;
//
// import javax.servlet.FilterChain;
// import javax.servlet.ServletException;
// import javax.servlet.ServletRequest;
// import javax.servlet.ServletResponse;
// import javax.servlet.http.HttpServletRequest;
//
// import org.springframework.security.core.Authentication;
// import org.springframework.security.core.context.SecurityContextHolder;
// import org.springframework.web.filter.GenericFilterBean;
//
// import lombok.RequiredArgsConstructor;
//
// @RequiredArgsConstructor
// public class JwtAuthenticationFilter extends GenericFilterBean {
//
// 	private final JwtProvider jwtProvider;
//
// 	@Override
// 	public void doFilter(ServletRequest request, ServletResponse response, FilterChain filterChain) throws
// 		IOException,
// 		ServletException {
//
// 		// 헤더에서 JWT를 받아온다
// 		String token = jwtProvider.resolveToken((HttpServletRequest)request);
// 		// 토큰 유효성 체크(유효한 토큰인가?)
// 		if (token != null && jwtProvider.validateToken(token)) {
//
// 			setAuthentication(token);
//
// 		} else {
//
// 		}
// 		filterChain.doFilter(request, response);
// 	}
//
// 	private void setAuthentication(String token) {
// 		Authentication authentication = jwtProvider.getAuthentication(token);
// 		SecurityContextHolder.getContext().setAuthentication(authentication);
// 	}
//
// }
