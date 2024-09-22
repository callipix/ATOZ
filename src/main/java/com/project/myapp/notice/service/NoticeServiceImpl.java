package com.project.myapp.notice.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.project.myapp.dto.NoticeDTO;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.notice.mapper.NoticeMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService {

	private final NoticeMapper noticeMapper;

	@Override
	@Transactional
	// @Cacheable(value = "NoticeMapper.findAll")
	public List<NoticeDTO> getAllNotices() {
		return this.noticeMapper.findAll();
	}

	@Override
	@Transactional
	@Cacheable(value = "NoticeMapper.findAll")
	public List<NoticeDTO> findAllByEhcache() {
		return this.noticeMapper.findAll();
	}

	@Override
	@Transactional
	// @Cacheable(value = "NoticeMapper.findByPage", key = "#request.requestURI + '-' + #pageNumber", condition = "#pageNumber <= 5")
	public List<NoticeDTO> findByPage(HttpServletRequest request, int pageNumber) {
		int startIdx = (pageNumber - 1) * 10;
		return noticeMapper.findByPage(startIdx);
	}

	@Override
	@Transactional
	public List<NoticeDTO> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate) {
		return this.noticeMapper.findNoticesByDates(startDate, endDate);
	}

	@Override
	@Transactional
	@Cacheable(value = "NoticeMapper.getNoticeTotalCount")
	public Integer getNoticeTotalCount() {
		return this.noticeMapper.getNoticeTotalCount();
	}

	@Override
	public Integer getSearchNoticeResultCount(SearchCondition sc) {

		return this.noticeMapper.getSearchNoticeResultCount(sc);
	}

	@Override
	@Transactional
	public List<NoticeDTO> noticeSearchSelectPage(SearchCondition sc) {

		List<NoticeDTO> noticeList = this.noticeMapper.noticeSearchSelectPage(sc);
		return noticeList;
	}

	@Override
	@Transactional
	@Cacheable(value = "NoticeMapper.noticeSearchSelectPage", key = "#sc.keyword+#sc.option+#sc.page+#sc.pageSize", condition = "#sc.page >= 4000000")
	public List<NoticeDTO> getNoticeListByEhcache(SearchCondition sc) {

		log.info("sc from getNoticeListByEhcache = {}", sc);
		List<NoticeDTO> noticeList = null;
		int result = 0;
		for (int i = 1; i <= 50; i++) {
			noticeList = this.noticeMapper.noticeSearchSelectPage(sc);
			result++;
		}
		return noticeList;

	}
}