package com.project.myapp.security.jwt.controller;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
public class RestApiController {

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
	public String secureEndpoint(HttpServletResponse response, HttpServletRequest request) {
		String authorization = null;

		Cookie[] cookies = request.getCookies();

		for (Cookie cookie : cookies) {
			log.info("cookie.getName() = {}", cookie.getName());
			if (cookie.getName().equals("Authorization")) {
				authorization = cookie.getValue();
			}
		}
		response.addHeader("Authorization", authorization);
		return authorization;
	}
}
