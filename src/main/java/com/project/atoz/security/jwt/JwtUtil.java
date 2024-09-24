package com.project.atoz.security.jwt;

import java.util.Date;

import javax.crypto.SecretKey;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Component
public class JwtUtil {
	/**
	 * JWT 발급 클래스
	 */

	private SecretKey secretKey;

	public JwtUtil(@Value("${jwt.token.key}") String secret) {
		byte[] byteSecretKey = Decoders.BASE64.decode(secret);
		secretKey = Keys.hmacShaKeyFor(byteSecretKey);
	}

	public String getUsername(String token) {

		return Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.get("username", String.class);
	}

	public String getRole(String token) {

		return Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.get("role", String.class);
	}

	public String getCategory(String token) {

		return Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.get("category", String.class);
	}

	public Boolean isExpired(String token) {

		return Jwts.parserBuilder()
			.setSigningKey(secretKey)
			.build()
			.parseClaimsJws(token)
			.getBody()
			.getExpiration()
			.before(new Date());
	}

	public String createJwt(String category, String username, String role, Long expiredMs) {

		return Jwts.builder()
			.claim("category", category)
			.claim("username", username)
			.claim("role", role)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			// .setExpiration(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expiredMs))
			.signWith(secretKey)
			.compact();
	}

	public String createJwt(String username, String role, Long expiredMs) {

		return Jwts.builder()
			.claim("username", username)
			.claim("role", role)
			.setIssuedAt(new Date(System.currentTimeMillis()))
			.setExpiration(new Date(System.currentTimeMillis() + expiredMs))
			.signWith(secretKey)
			.compact();
	}
}