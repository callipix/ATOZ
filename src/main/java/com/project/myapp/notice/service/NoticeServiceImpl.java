package com.project.myapp.notice.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

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
	// @Cacheable(value = "NoticeMapper.findAll")
	public List<NoticeDTO> getAllNotices() {
		return this.noticeMapper.findAll();
	}

	@Override
	// @Cacheable(value = "NoticeMapper.findByPage", key = "#request.requestURI + '-' + #pageNumber", condition = "#pageNumber <= 5")
	public List<NoticeDTO> findByPage(HttpServletRequest request, int pageNumber) {
		int startIdx = (pageNumber - 1) * 10;
		return noticeMapper.findByPage(startIdx);
	}

	@Override
	public List<NoticeDTO> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate) {
		return this.noticeMapper.findNoticesByDates(startDate, endDate);
	}

	@Override
	@Cacheable(value = "NoticeMapper.getNoticeTotalCount")
	public Integer getNoticeTotalCount() {
		return this.noticeMapper.getNoticeTotalCount();
	}

	@Override
	public Integer getSearchNoticeResultCount(SearchCondition sc) {

		return this.noticeMapper.getSearchNoticeResultCount(sc);
	}

	@Override
//	@Cacheable(value = "NoticeMapper.noticeSearchSelectPage")
	public List<NoticeDTO> noticeSearchSelectPage(SearchCondition sc) {

		List<NoticeDTO> noticeList = this.noticeMapper.noticeSearchSelectPage(sc);

		return noticeList;
	}
	@Override
	@Cacheable(value = "NoticeMapper.noticeSearchSelectPage")
	public List<NoticeDTO> getNoticeListByEhcache(SearchCondition sc) {

		List<NoticeDTO> noticeList = this.noticeMapper.noticeSearchSelectPage(sc);

		return noticeList;
	}
}