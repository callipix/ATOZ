package com.project.myapp.security;

import com.project.myapp.security.auth.CustomDetails;
import com.project.myapp.security.auth.CustomDetailsService;
import io.jsonwebtoken.Claims;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import java.util.Base64;
import java.util.Date;

@Component
@RequiredArgsConstructor
@Slf4j
public class JwtTokenProvider {
    private final CustomDetailsService customDetailsService;

    @Value("${jwt.token.key}")
    private String secretKey;

    private Long tokenValidTile = 240 * 60 * 1000L;

    @PostConstruct
    public void init() {
        secretKey = Base64.getEncoder().encodeToString(secretKey.getBytes());
    }

    // JWT토큰 생성
    public String createToken(String email , String role) {
        Date now = new Date();
        
        Claims claims = Jwts.claims()
                .setSubject("access_token")
                .setIssuedAt(now)
                .setExpiration(new Date(now.getTime() + tokenValidTile));

        claims.put("email", email);
        claims.put("role", role);
        return Jwts.builder()
                .setHeaderParam("typ", "JWT")
                .setClaims(claims)
                .signWith(SignatureAlgorithm.HS256, secretKey)
                .compact();
    }
    
    public String resolveToken(HttpServletRequest request) {
        return request.getHeader("JWT");
    }

    public boolean validateToken(String jwtToken) {

        try {
            Claims claims = Jwts.parser().setSigningKey(secretKey).parseClaimsJws(jwtToken).getBody();
            return !claims.getExpiration().before(new Date());
        } catch (Exception e) {
            return false;
        }
    }

    public Authentication getAuthentication(String token) {

        CustomDetails customDetails = (CustomDetails) customDetailsService.loadUserByUsername(this.getUserPk(token));
        return new UsernamePasswordAuthenticationToken(customDetails,"",customDetails.getAuthorities());
    }
    public String getUserPk(String token){
        return (String) Jwts.parser().setSigningKey(secretKey).parseClaimsJws(token).getBody().get("email");
    }
}
