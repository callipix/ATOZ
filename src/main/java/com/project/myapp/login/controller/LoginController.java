package com.project.myapp.login.controller;

import java.io.UnsupportedEncodingException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.security.JwtTokenProvider;
import com.project.myapp.security.UserRoleEnum;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.project.myapp.login.service.LoginService;
import com.project.myapp.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/login")
@RequiredArgsConstructor
public class LoginController {

	private final LoginService loginService;
	private final Map<String, String> oauth2AuthenticationUrls = new HashMap<>();
	private final BCryptPasswordEncoder bCryptPasswordEncoder;
	private final JwtTokenProvider jwtTokenProvider;

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

	// @GetMapping("/oauth2/code/google")
	public void signinKakao(@RequestParam String code) {
		log.info("code = {}", code);
	}

	@PostMapping("/login")
	public String login(String id, String password, String toURL, HttpServletRequest request
		, Authentication authentication, @AuthenticationPrincipal CustomDetails userDetails) throws
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

		log.info("==============================================================");
		CustomDetails customDetails = (CustomDetails)authentication.getPrincipal();
		log.info("authentication = {}", customDetails.getUser());
		log.info("userDetails = {}", userDetails.getUser());

		log.info("PrincipalDetails = {}", userDetails.getUser());

		// 3.홈으로 이동
		toURL = toURL == null || toURL.equals("") ? "/" : toURL;
		log.info("toURL = {}", toURL);
		return "redirect:" + toURL;
	}

	public String jwtLogin(UserDTO userDTO , HttpServletResponse response){

		UserDTO user = this.loginService.passCheckById("aa");
		String checkEmail = user.getEmail();
		String role = user.getRole();

		String token = jwtTokenProvider.createToken(checkEmail , role);
		response.setHeader("JWT", token);
		return token;
	}


	public boolean loginCheck(String id, String password) {

		String passwordHash = this.loginService.passCheckById(id).getPassword();
		log.info("passwordHash = {}", passwordHash);
		boolean passCheck = bCryptPasswordEncoder.matches(password, passwordHash);
		if (passCheck) {
			log.info("로그인 성공");
			return true;
		} else {
			log.info("로그인 실패, 아이디 또는 패스워드 불일치");
			return false;
		}
	}
}