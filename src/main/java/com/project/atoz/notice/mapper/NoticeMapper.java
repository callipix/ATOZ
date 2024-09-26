package com.project.atoz.notice.mapper;

import java.time.LocalDateTime;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.project.atoz.dto.NoticeDTO;
import com.project.atoz.dto.SearchCondition;

@Mapper
public interface NoticeMapper {
	List<NoticeDTO> findAll();

	List<NoticeDTO> findByPage(int startIdx);

//	List<NoticeDTO> findNoticesByDates(@Param("startDate") LocalDateTime startDate,
//		@Param("endDate") LocalDateTime endDate);

	Integer getNoticeTotalCount();

	List<NoticeDTO> noticeSearchSelectPage(SearchCondition sc);

	List<NoticeDTO> noticeSearchSelectPage2(SearchCondition sc);

	Integer getSearchNoticeResultCount(SearchCondition sc);
}
