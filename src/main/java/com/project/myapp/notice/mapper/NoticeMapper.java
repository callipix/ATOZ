package com.project.myapp.notice.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.myapp.dto.NoticeDTO;
import com.project.myapp.dto.SearchCondition;

@Mapper
public interface NoticeMapper {
	List<NoticeDTO> findAll();

	List<NoticeDTO> findByPage(int startIdx);

	List<NoticeDTO> findNoticesByDates(@Param("startDate") LocalDateTime startDate,
		@Param("endDate") LocalDateTime endDate);

	Integer getNoticeTotalCount();

	List<NoticeDTO> noticeSearchSelectPage(SearchCondition sc);

	Integer getSearchNoticeResultCount(SearchCondition sc);
}
