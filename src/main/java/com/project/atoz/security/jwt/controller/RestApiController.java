package com.project.atoz.security.jwt.controller;

import java.io.IOException;
import java.nio.charset.StandardCharsets;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.codec.binary.StringUtils;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.atoz.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RestApiController {

	@ResponseBody
	@GetMapping("/secureEndpoint")
	public String secureEndpoint(HttpServletResponse response, HttpServletRequest request) {
		String access = null;
		String refresh = null;

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			log.info("cookie.getName() for secureEndpoint = {}", cookie.getName());
			if (cookie.getName().equals("access")) {
				access = cookie.getValue();
			}
			if (cookie.getName().equals("refresh")) {
				refresh = cookie.getValue();
			}
		}
		log.info("cookies = {}", cookies);
		log.info("access = {}", access);
		log.info("refresh = {}", refresh);

		response.addHeader("access", access);
		String accessToken = request.getHeader("access");

		Cookie cookie = new Cookie("access", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return accessToken;
	}

	@ResponseBody
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
	@ResponseBody
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
	@ResponseBody
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		log.info("logout시 CustomLogoutFilter에 의해 처리되어서 여기에 안와야 정상");

		return "logout?";
	}
}
