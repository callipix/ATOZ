package com.project.myapp.notice.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
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
//	@Cacheable(value = "NoticeMapper.findAll")
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
//	@Cacheable(value = "NoticeMapper.getNoticeTotalCount")
	public Integer getNoticeTotalCount() {
		return this.noticeMapper.getNoticeTotalCount();
	}

	@Override
	@Transactional
	@Cacheable(value = "NoticeMapper.getSearchNoticeResultCount", key = "#sc.keyword+'-'+#sc.option+'-'+#sc.page+'-'+#sc.pageSize")
	public Integer getSearchNoticeResultCount(SearchCondition sc) {

		return this.noticeMapper.getSearchNoticeResultCount(sc);
	}

	@Override
	public List<NoticeDTO> noticeSearchSelectPage2(SearchCondition sc) {

		log.info("sc from noticeSearchSelectPage2 = {}", sc);

		List<NoticeDTO> noticeList = this.noticeMapper.noticeSearchSelectPage2(sc);
		return noticeList;
	}

	@Override
	@Transactional
	@Cacheable(value = "NoticeMapper.noticeSearchSelectPage", key = "#sc.keyword+'-'+#sc.option+'-'+#sc.page+'-'+#sc.pageSize")
	public List<NoticeDTO> getNoticeListByEhcache(SearchCondition sc) {

		log.info("sc.getPage from getNoticeListByEhcache = {}", sc.getPage());
		log.info("sc.getPageSize from getNoticeListByEhcache = {}", sc.getPageSize());
		log.info("sc.getOffset from getNoticeListByEhcache = {}", sc.getOffset());
		log.info("sc.getKeyword from getNoticeListByEhcache = {}", sc.getKeyword());
		log.info("sc.getOption from getNoticeListByEhcache = {}", sc.getOption());
		log.info("sc.getQueryString from getNoticeListByEhcache = {}", sc.getQueryString());

		List<NoticeDTO> noticeList = this.noticeMapper.noticeSearchSelectPage(sc);
		return noticeList;
	}
}