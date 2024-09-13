package com.project.myapp.security.jwt.controller;

import com.project.myapp.security.jwt.JwtUtil;
import io.jsonwebtoken.ExpiredJwtException;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@RestController
@RequiredArgsConstructor
public class JwtController {

    private final JwtUtil jwtUtil;

    @PostMapping("/test")
    public String adminP(HttpServletRequest request){
        String authorization = request.getHeader("Authorization");
        System.out.println("authorization for JwtController = " + authorization);
        return "Admin Controller";
    }

    public ResponseEntity<?> reissue(HttpServletRequest request, HttpServletResponse response) {

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
        }    // 토큰이 refresh인지 확인(발급시 페이로드에 명시)
            return new ResponseEntity<>("refresh token expired", HttpStatus.BAD_REQUEST);
    }
}
