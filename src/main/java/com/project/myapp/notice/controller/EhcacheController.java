package com.project.myapp.notice.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.cache.CacheManager;
import org.springframework.cache.ehcache.EhCacheCache;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import net.sf.ehcache.Ehcache;
import net.sf.ehcache.Element;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api")
public class EhcacheController {
	private final CacheManager cacheManager;

	@GetMapping("/ehcache")
	public Object findAll() {

		List<Map<String, List<String>>> result = cacheManager.getCacheNames().stream()
			.map(cacheName -> {
				EhCacheCache cache = (EhCacheCache)cacheManager.getCache(cacheName);
				Ehcache ehcache = cache.getNativeCache();
				Map<String, List<String>> entry = new HashMap<>();

				ehcache.getKeys().forEach(key -> {
					Element element = ehcache.get(key);
					if (element != null) {
						entry.computeIfAbsent(cacheName, k -> new ArrayList<>()).add(element.toString());
					}
				});

				return entry;
			})
			.collect(Collectors.toList());

		log.info("result = {}", result);
		return result;
	}
}