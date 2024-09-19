package com.project.myapp.notice.service;

import java.time.LocalDateTime;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import com.project.myapp.dto.NoticeDTO;
import com.project.myapp.dto.SearchCondition;

public interface NoticeService {
	List<NoticeDTO> getAllNotices();

	List<NoticeDTO> findByPage(HttpServletRequest request, int pageNumber);

	List<NoticeDTO> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate);

	Integer getNoticeTotalCount();

	Integer getSearchNoticeResultCount(SearchCondition sc);

	List<NoticeDTO> getNoticeListByEhcache(SearchCondition sc);

	List<NoticeDTO> noticeSearchSelectPage(SearchCondition sc);

}
