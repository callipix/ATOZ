package com.project.myapp.security.handler;

import lombok.extern.slf4j.Slf4j;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.security.web.authentication.SavedRequestAwareAuthenticationSuccessHandler;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

@Slf4j
public class CustomAuthenticationSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException {
        // 기본 리다이렉션 URL 설정
        String redirectUrl = "/";

        log.info("authentication = {}", authentication.getAuthorities());
        List<String> roleNames = new ArrayList<String>();
        authentication.getAuthorities().forEach(authority->{
            roleNames.add(authority.getAuthority());
        });
        log.info("roleNames = {}", roleNames);
        // 사용자의 권한에 따라 리다이렉션할 URL 결정
        if (roleNames.contains("ROLE_ADMIN")) {
            redirectUrl = "/myApp/adminTest";
        } else if (roleNames.contains("ROLE_USER")) {
            redirectUrl = "/myApp/";
        }
        // 응답 객체를 사용해 리다이렉션
        log.info("redirectUrl = {}", redirectUrl);
        response.sendRedirect(redirectUrl);
    }
}