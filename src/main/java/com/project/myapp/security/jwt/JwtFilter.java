package com.project.myapp.security.jwt;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.security.auth.CustomDetails;
import com.project.myapp.security.oauth.service.CustomOAuth2UserService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.web.filter.OncePerRequestFilter;

import javax.servlet.FilterChain;
import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
@Slf4j
@RequiredArgsConstructor
public class JwtFilter extends OncePerRequestFilter {

    private final JwtUtil jwtUtil;

    @Override
    protected void doFilterInternal(HttpServletRequest request, HttpServletResponse response, FilterChain filterChain) throws ServletException, IOException {

        // cookie들을 불러온 뒤 Authorization key에 담긴 쿠키를 찾는다
        String authorization = null;
        Cookie[] cookies = request.getCookies();
        for(Cookie cookie : cookies) {
            log.info("cookie.getName() = {}", cookie.getName());
            if(cookie.getName().equals("Authorization")) {
                authorization = cookie.getValue();
            }
        }
        if(authorization == null){
            log.info("token is empty");
            filterChain.doFilter(request, response);
            // 메서드 종료
            return;
        }
        // 토큰
        String token = authorization;

        // 토큰 소멸 시간 검증
        if(jwtUtil.isExpired(token)){
            log.info("token is expired");
            filterChain.doFilter(request, response);
            // 메서드 종료
            return;
        }

        // 토큰에서 username과 role 획득
        String username = jwtUtil.getUsername(token);
        String role = jwtUtil.getRole(token);

        // userDTO 생성하여 값 추가
        UserDTO userDTO = new UserDTO();
        userDTO.setId(username);
        userDTO.setRole(role);

        // userDetails에 회원 정보 객체 추가
        CustomDetails customDetails = new CustomDetails(userDTO);

        // 스프링 시큐리티 인증 토큰 생성
        Authentication authToken = new UsernamePasswordAuthenticationToken(customDetails, null , customDetails.getAuthorities());

        // 세션에 사용자 등록
        SecurityContextHolder.getContext().setAuthentication(authToken);

        filterChain.doFilter(request, response);
    }

}
