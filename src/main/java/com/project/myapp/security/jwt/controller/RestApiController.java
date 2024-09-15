package com.project.myapp.security.jwt.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.myapp.login.service.LoginService;
import com.project.myapp.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RestApiController {

	private final LoginService loginService;

	@GetMapping("/home")
	public String home(HttpServletResponse response) {
		log.info("response for RestApiController = {}", response.getHeader("access"));
		return "/";
	}

	@GetMapping("/addToken")
	public String addToken(HttpServletResponse response, HttpServletRequest request) {
		Cookie[] cookie = request.getCookies();
		log.info("cookie = {}", cookie);

		return "/addToken";
	}

	@ResponseBody
	@GetMapping("/secure-endpoint")
	public String secureEndpoint(HttpServletResponse response, HttpServletRequest request) throws IOException {
		String authorization = null;
		String access = null;
		String refresh = null;

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			log.info("cookie.getName() = {}", cookie.getName());
			if (cookie.getName().equals("Authorization")) {
				authorization = cookie.getValue();
			}
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
		log.info("");

		// response.setHeader("Authorization", "Bearer " + authorization);
		response.addHeader("access", access);

		return authorization;
	}

	@ResponseBody
	@GetMapping("/header-endpoint")
	public String headerPoint(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String accessToken = request.getHeader("access");

		return accessToken;
	}

	@ResponseBody
	@PostMapping("/jwtLogin")
	public String jwtLogin(HttpServletRequest request, HttpServletResponse response) {

		log.info("jwtLogin 호출");

		String access = request.getHeader("access");
		log.info("access for jwtLogin = {}", access);
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("userDetails.getName() = {}", userDetails.getName());

		return userDetails.getName();
	}

	@ResponseBody
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		return "logout?";
	}

}
