package com.project.myapp.notice.mapper;

import com.project.myapp.dto.Notice;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import java.time.LocalDateTime;
import java.util.List;

@Mapper
public interface NoticeMapper {
    List<Notice> findAll();

    List<Notice> findByPage(int startIdx);

    List<Notice> findNoticesByDates(@Param("startDate") LocalDateTime startDate, @Param("endDate") LocalDateTime endDate);
}
