package com.project.myapp.notice.service;

import com.project.myapp.dto.Notice;
import com.project.myapp.notice.mapper.NoticeMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletRequest;
import java.time.LocalDateTime;
import java.util.List;


@Slf4j
@Service
@RequiredArgsConstructor
public class NoticeServiceImpl implements NoticeService{

    private final NoticeMapper noticeMapper;

    @Override
    @Cacheable(value = "NoticeMapper.findAll")
    public List<Notice> getAllNotices() {
        return noticeMapper.findAll();
    }

    @Override
    @Cacheable(value = "NoticeMapper.findByPage", key = "#request.requestURI + '-' + #pageNumber", condition = "#pageNumber <= 5")
    public List<Notice> findByPage(HttpServletRequest request, int pageNumber) {
        int startIdx = (pageNumber - 1) * 10;
        return noticeMapper.findByPage(startIdx);
    }

    @Override
    public List<Notice> findNoticesByDates(LocalDateTime startDate, LocalDateTime endDate) {
        return noticeMapper.findNoticesByDates(startDate, endDate);
    }
}
