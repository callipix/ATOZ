package com.project.myapp.security.handler;

import com.project.myapp.security.auth.CustomDetails;
import com.project.myapp.security.jwt.JwtUtil;
import com.project.myapp.security.oauth.service.CustomOAuth2User;
import com.project.myapp.security.oauth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;

@Slf4j
@Component
@RequiredArgsConstructor
public class CustomSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {

    private final JwtUtil jwtUtil;

    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {

        System.out.println("여길 안와?");
        CustomDetails customUserDetails = (CustomDetails) authentication.getPrincipal();

        String username = customUserDetails.getUsername();

        Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
        Iterator<? extends GrantedAuthority> iterator = authorities.iterator();
        GrantedAuthority auth = iterator.next();
        String role = auth.getAuthority();

        String token = jwtUtil.createJwt(username, role , 60 * 60 * 60L);
        log.info("token = {}", token);
        log.info("role =  {}", role);
        log.info("auth =  {}", auth);
        log.info("iterator = {}", iterator);
        log.info("authorities = {}", authorities);
        log.info("username = {}", username);
        log.info("customUserDetails = {}", customUserDetails);

        response.addCookie(createCooke("Authorization" , token));
        response.sendRedirect("/");
//
//        // 기본 리다이렉션 URL 설정
//        String redirectUrl = "/";
//
//        log.info("authentication = {}", authentication.getAuthorities());
//        List<String> roleNames = new ArrayList<String>();
//        authentication.getAuthorities().forEach(authority->{
//            roleNames.add(authority.getAuthority());
//        });
//        log.info("roleNames = {}", roleNames);
//        // 사용자의 권한에 따라 리다이렉션할 URL 결정
//        if (roleNames.contains("ROLE_ADMIN")) {
//            redirectUrl = "/myApp/adminTest";
//        } else if (roleNames.contains("ROLE_USER")) {
//            redirectUrl = "/myApp/";
//        }
//        // 응답 객체를 사용해 리다이렉션
//        log.info("redirectUrl = {}", redirectUrl);
//        response.sendRedirect(redirectUrl);
    }

    private Cookie createCooke(String key, String value) {
        Cookie cookie = new Cookie(key, value);
        cookie.setMaxAge(60 * 60 * 60);
        cookie.setPath("/");
        cookie.setHttpOnly(true);

        return cookie;
    }
}