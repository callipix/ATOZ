//package com.project.myapp.security.jwt;
//
//import com.project.myapp.utiles.properties.JwtProperties;
//import lombok.RequiredArgsConstructor;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.data.redis.connection.RedisConnectionFactory;
//import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
//import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
//
//@Configuration
//@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
//@RequiredArgsConstructor
//public class RedisConfig {
//
//    private final JwtProperties jwtProperties;
//
//    @Bean
//    public RedisConnectionFactory redisConnectionFactory() {
//        return new LettuceConnectionFactory();
//    }
//
//}
