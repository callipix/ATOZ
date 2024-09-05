package com.project.myapp.login.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.oauth2.client.registration.ClientRegistrationRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.project.myapp.login.service.LoginService;
import com.project.myapp.utiles.properties.OAuth2Properties;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	private static String authorizationRequestBaseUri = "oauth2/authorization";
	private final Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	private final ClientRegistrationRepository clientRegistrationRepository;
	private final OAuth2Properties oAuth2Properties;
	private final BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping("/logout")
	public String logOut(HttpSession session, HttpServletRequest request) {
		session.invalidate();
		session = request.getSession();
		session.setAttribute("message", "로그아웃이 완료되었습니다.");
		return "redirect:logoutSuccess";
	}

	@GetMapping("/loginForm")
	public String loginForm() {
		return "login/loginForm";
	}

	@PostMapping("/login")
	public String login(String id, String password, String toURL, HttpServletRequest request) throws
		UnsupportedEncodingException {
		log.info("id, password = {}, {}", id, password);

		HttpSession session = null;
		if (!loginCheck(id, password)) {
			session = request.getSession();
			session.setAttribute("message", "id 또는 패스워드가 일치하지 않습니다.");
			return "redirect:/login/loginFailPage";
		}
		session = request.getSession();
		session.setAttribute("id", id);
		session.setAttribute("password", password);

		// 3.홈으로 이동
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		log.info("toURL = {}", toURL);
		return "redirect:" + toURL;
	}

	public boolean loginCheck(String id, String password) {
		int result = 0;
		result = this.loginService.loginCheck(id, password);
		if (result == 1) {
			log.info("로그인 성공");
			return true;
		} else {
			log.info("로그인 실패, 아이디 또는 패스워드 불일치");
			return false;
		}
	}
}