package com.project.myapp.security.jwt.controller;

import java.io.IOException;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.myapp.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequiredArgsConstructor
public class RestApiController {

	@GetMapping("/addToken")
	public String addToken(HttpServletResponse response, HttpServletRequest request) {
		Cookie[] cookie = request.getCookies();
		String test = request.getHeader("access");
		log.info("cookie = {}", cookie);
		log.info("test = {}", test);

		return "/addToken";
	}

	@ResponseBody
	@GetMapping("/secure-endpoint")
	public String secureEndpoint(HttpServletResponse response, HttpServletRequest request) throws IOException {
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

		// response.setHeader("Authorization", "Bearer " + authorization);
		response.addHeader("access", access);

		return access;
	}

	@ResponseBody
	@GetMapping("/header-endpoint")
	public String headerPoint(HttpServletResponse response, HttpServletRequest request) throws IOException {

		String accessToken = request.getHeader("access");
		Cookie cookie = new Cookie("access", null);
		cookie.setMaxAge(0);
		cookie.setPath("/");
		response.addCookie(cookie);
		return accessToken;
	}

	@ResponseBody
	@PostMapping("/jwtLogin")
	public ResponseEntity<String> jwtLogin(HttpServletRequest request, HttpServletResponse response) {

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
	@PostMapping("/generalLogin")
	public String general(HttpServletRequest request, HttpServletResponse response) {

		log.info("general 호출");

		String access = request.getHeader("access");
		log.info("access for general = {}", access);
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("userDetails.getName() for general = {}", userDetails.getName());

		return userDetails.getName();
	}

	@ResponseBody
	@PostMapping("/logout")
	public String logout(HttpServletRequest request, HttpServletResponse response) {

		log.info("logout시 CustomLogoutFilter에 의해 처리되어서 여기에 안와야 정상");

		return "logout?";
	}

	@ResponseBody
	@GetMapping("/tokenCheck")
	public String tokenCheck(HttpServletResponse response, HttpServletRequest request) {

		String access = request.getHeader("access");
		String isUser = "";
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		if (access != null || userDetails != null) {
			isUser = userDetails.getName();
		}
		return isUser;
	}

}
