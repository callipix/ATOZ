package com.project.atoz.notice.controller;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;

import com.project.atoz.dto.NoticeDTO;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.notice.service.NoticeService;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@WebAppConfiguration
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class NoticeControllerTest {

	@Autowired
	private NoticeController noticeController;
	@Autowired
	private NoticeService noticeService;

	@Test
	public void findAll() {
	}

	@Test
	public void findByPage() {
	}

	@Test
	public void findNoticesByDates() {
	}

	@Test
	public void getNoticesCount() {
	}

	@Test
	public void getNoticeTotalCount() {
	}

	@Test
	public void getNoticeList() {
	}

	@Test
	public void getNoticeListByEhcache() {
	}

	@Test
	public void averageTest() {
		int totalSum = 0;
		int count = 0;
		String option = "";
		String keyword = "";
		Integer page = 4999990;
		Integer pageSize = 10;
		SearchCondition sc = new SearchCondition();
		sc.setOption(option);
		sc.setKeyword(keyword);
		sc.setPage(page);
		sc.setPageSize(pageSize);
		List<NoticeDTO> noticeDTO = null;

		for (int i = 0; i < 10; i++) {
			noticeDTO = noticeService.getNoticeListByEhcache(sc);
			count++;
		}
		assertTrue(count == 10);
	}
}