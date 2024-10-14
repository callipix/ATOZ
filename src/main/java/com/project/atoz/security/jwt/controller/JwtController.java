package com.project.atoz.security.jwt.controller;

import java.nio.charset.StandardCharsets;
import java.util.Date;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.project.atoz.dto.RefreshDTO;
import com.project.atoz.security.auth.CustomDetails;
import com.project.atoz.security.jwt.JwtUtil;
import com.project.atoz.security.jwt.mapper.RefreshMapper;

import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class JwtController {
	/**
	 * Access Token 만료시 재발급 하기 위한 컨트롤러
	 */
	private final JwtUtil jwtUtil;
	private final RefreshMapper refreshMapper;

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
		log.info("cookies = {}", cookies);
		log.info("refresh = {}", refresh);

		if (refresh == null) {
			return new ResponseEntity<>("refresh token null", HttpStatus.BAD_REQUEST);
		}
		try {
			jwtUtil.isExpired(refresh);
		} catch (ExpiredJwtException e) {
			return new ResponseEntity<>("refresh token expired from ExpiredJwtException", HttpStatus.BAD_REQUEST);
		}

		// Refresh 토큰인지 확인(발급시 페이로드에 명시)
		String category = jwtUtil.getCategory(refresh);
		log.info("category = {}", category);

		if (!category.equals("refresh")) {
			return new ResponseEntity<>("invalid refresh token", HttpStatus.BAD_REQUEST);
		}

		// DB에 저장 되어 있는지 확인
		Boolean isExits = refreshMapper.existsByRefreshToken(refresh);
		if (!isExits) {
			return new ResponseEntity<>("refresh token expired in database", HttpStatus.BAD_REQUEST);
		}

		String username = jwtUtil.getUsername(refresh);
		String role = jwtUtil.getRole(refresh);

		//make new jwt
		String newAccess = jwtUtil.createJwt("access", username, role, 6000000L);
		String newRefresh = jwtUtil.createJwt("refresh", username, role, 86400000L);

		refreshMapper.deleteByRefreshToken(refresh);
		addRefreshToken(username, newRefresh, 86400000L);

		response.setHeader("access", newAccess);
		response.addCookie(createCookie("refresh", newRefresh));

		Cookie cookie = new Cookie("access", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);

		log.info("jwt Controller 끝");
		return new ResponseEntity<>(response.getHeader("access"), HttpStatus.OK);
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

	/*
	RestApiController랑 통합
	 */

	@GetMapping("/secureEndpoint")
	public String secureEndpoint(HttpServletResponse response, HttpServletRequest request) {

		String access = null;
		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			if (cookie.getName().equals("access")) {
				access = cookie.getValue();
			}
		}

		response.addHeader("access", access);
		String accessToken = request.getHeader("access");

		Cookie cookie = new Cookie("access", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return accessToken;
	}

	@PostMapping(value = "/jwtLogin", produces = "application/json; charset=utf-8")
	public ResponseEntity<String> jwtLogin(HttpServletRequest request) {

		log.info("jwtLogin 호출");

		String access = request.getHeader("access");
		log.info("access for jwtLogin = {}", access);
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("userDetails.getName() = {}", userDetails.getName());

		return ResponseEntity.ok()
			.contentType(MediaType.APPLICATION_JSON_UTF8)
			.body(userDetails.getName());
	}

	@GetMapping(value = "/tokenCheck", produces = "application/json; charset=utf-8")
	public String tokenCheck(HttpServletRequest request, HttpServletResponse response) {

		String access = request.getHeader("access");
		String isUser = "";
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("access from tokenCheck = {}", access);
		log.info("userDetails from tokenCheck = {}", userDetails);
		if (access != null && userDetails != null) {
			isUser = userDetails.getName();
		}

		log.info("isUser from tokenCheck = {}", isUser);
		isUser = StringUtils.newStringUtf8(isUser.getBytes(StandardCharsets.UTF_8));
		log.info("isUser.utf8 from tokenCheck = {}", isUser);
		response.setContentType(String.valueOf(MediaType.APPLICATION_JSON_UTF8));
		return isUser;
	}

	@PostMapping("/logout")
	public String logout() {

		log.info("logout → CustomLogoutFilter 에서 처리 되니까 여기에 안와야 정상");

		return "logout?";
	}
}
