package com.project.myapp.security.jwt;

import java.time.Duration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.lettuce.LettuceConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;

import com.project.myapp.utiles.properties.JwtProperties;

import lombok.RequiredArgsConstructor;

@Configuration
@EnableRedisHttpSession(maxInactiveIntervalInSeconds = 10)
@RequiredArgsConstructor
public class RedisConfig {

	private final JwtProperties jwtProperties;

	/**
	 * Redis 서버와 연결을 생성하고 관리하는 역할
	 * Spring ↔ Redis 통신을 위해 사용하는 인터페이스
	 * @return
	 */
	@Bean
	public RedisConnectionFactory redisConnectionFactory() {
		return new LettuceConnectionFactory(jwtProperties.getHost(), jwtProperties.getPort());
	}

	/**
	 * RedisTemplate : Redis에 데이터를 읽고 쓰기 위한 주요 템플릿 클래스
	 * ConnectionFactory 설정 : 위에서 생성한 redisConnectionFactory를 사용하여 Redis와의 연결 설정
	 * key-value 직렬화 설정 : 키-해시키, 해시 값 모두를 StringRedisSerializer로 직렬화 하여 Redis에 저장하거나 읽어올때 문자열 형식으로 처리
	 * → Redis와의 데이터 직렬화 및 역직렬화 관리
	 * Redis에 key-value 저장소 작업을 수행할 수 있도록 하는 인터페이스로 사용
	 * @param redisConnectionFactory 위에서 생성된 연결객체
	 * @return
	 */
	@Bean
	public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisConnectionFactory) {
		RedisTemplate<String, String> redisTemplate = new RedisTemplate<>();
		redisTemplate.setConnectionFactory(redisConnectionFactory);
		redisTemplate.setKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashKeySerializer(new StringRedisSerializer());
		redisTemplate.setHashValueSerializer(new StringRedisSerializer());
		return redisTemplate;
	}

	/**
	 * Spring의 캐시추상화를 사용하여 Redis를 캐시 스토어로 사용하는 캐시 관리자를 제공
	 * RedisCacheManagerBuilder : redisConnectionFactory를 사용하여 Redis와의 연결 설정
	 * RedisCacheConfiguration : 기본 캐시 설정 지정
	 * - 값 직렬화 : GenericJackson2JsonRedisSerializer를 사용하여 캐시된 데이터를 JSON 형식으로 직렬화
	 * TTL(Time to Live) : 캐시항목의 기본 TTL을 설정(여기선 5분 설정)
	 * @param redisConnectionFactory 위에서 생성된 연결 객체
	 * @return
	 */
	@Bean
	public RedisCacheManager cacheManager(RedisConnectionFactory redisConnectionFactory) {
		RedisCacheManager.RedisCacheManagerBuilder builder = RedisCacheManager.builder(redisConnectionFactory);
		RedisCacheManager.RedisCacheManagerBuilder.fromConnectionFactory(redisConnectionFactory());

		RedisCacheConfiguration configuration = RedisCacheConfiguration.defaultCacheConfig()
			.serializeValuesWith(RedisSerializationContext.SerializationPair
				.fromSerializer(new GenericJackson2JsonRedisSerializer()))
			.entryTtl(Duration.ofMinutes(5));
		builder.cacheDefaults(configuration);
		return builder.build();
	}
}
