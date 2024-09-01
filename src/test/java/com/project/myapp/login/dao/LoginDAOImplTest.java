package com.project.myapp.login.dao;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import junit.framework.TestCase;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class LoginDAOImplTest extends TestCase {

	@Autowired
	LoginDAO loginDAO;

	@Test
	public void testLoginCheck() {

		int result = 0;
		Map<String, String> map = new HashMap<String, String>();
		map.put("id", "aaaa1234");
		map.put("password", "1111111111a");
		result = this.loginDAO.loginCheck(map);
		log.info("map = {}", map);
		log.info("result = {}", result);

		assertTrue(result == 1);

	}
}