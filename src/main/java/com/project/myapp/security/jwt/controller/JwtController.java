package com.project.myapp.security.jwt.controller;

import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.myapp.security.jwt.JwtUtil;
import com.project.myapp.security.jwt.RefreshDTO;
import com.project.myapp.security.jwt.mapper.RefreshMapper;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JwtController {

	private final JwtUtil jwtUtil;
	private final RefreshMapper refreshMapper;

	@PostMapping("/test")
	public String adminP(HttpServletRequest request) {
		String authorization = request.getHeader("Authorization");
		log.info("authorization for JwtController = {}", authorization);
		return "Admin Controller";
	}

	@PostMapping("/reissue")
	public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {

		log.info("jwt Controller 시작");
		// get refresh token
		String refresh = null;
		Cookie[] cookies = request.getCookies();
		for (Cookie cookie : cookies) {

			if (cookie.getName().equals("refresh")) {
				refresh = cookie.getValue();
			}
		}

		if (refresh == null) {
			return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
		}
		try {
			jwtUtil.isExpired(refresh);
		} catch (ExpiredJwtException e) {
			return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
		}
		// 토큰이 refresh인지 확인(발급시 페이로드에 명시)
		String category = jwtUtil.getCategory(refresh);

		if (!category.equals("refresh")) {
			return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
		}

		Boolean isExits = refreshMapper.existsByRefreshToken(refresh);
		if (!isExits) {
			return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
		}

		String username = jwtUtil.getUsername(refresh);
		String role = jwtUtil.getRole(refresh);

		//make new jwt
		String newAccess = jwtUtil.createJwt("access", username, role, 6666666L);
		String newRefresh = jwtUtil.createJwt("refresh", username, role, 888888888L);

		refreshMapper.deleteByRefreshToken(refresh);
		addRefreshToken(username, newRefresh, 88888888L);

		response.setHeader("access", newAccess);
		response.addCookie(createCookie("refresh", newRefresh));

		log.info("jwt Controller 끝");
		return new ResponseEntity<>(HttpStatus.OK);
	}

	private Cookie createCookie(String key, String value) {

		Cookie cookie = new Cookie(key, value);
		cookie.setMaxAge(24 * 60 * 60);
		//cookie.setSecure(true);
		//cookie.setPath("/");
		cookie.setHttpOnly(true);

		return cookie;
	}

	private void addRefreshToken(String username, String refresh, Long expiredMs) {
		Date date = new Date(System.currentTimeMillis() + expiredMs);

		RefreshDTO refreshDTO = new RefreshDTO();
		refreshDTO.setRefresh(refresh);
		refreshDTO.setUsername(username);
		refreshDTO.setExpiration(date.toString());

		refreshMapper.insertSave(refreshDTO);

	}
}
