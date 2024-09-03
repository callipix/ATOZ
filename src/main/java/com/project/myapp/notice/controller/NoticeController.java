package com.project.myapp.notice.controller;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.project.myapp.dto.NoticeDTO;
import com.project.myapp.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class NoticeController {

	private final NoticeService noticeService;

	@GetMapping("")
	public ResponseEntity<Object> findAll() {
		List<NoticeDTO> noticeDTO = noticeService.getAllNotices();
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

	@GetMapping("/{page}")
	public ResponseEntity<Object> findByPage(HttpServletRequest request, @PathVariable("page") Integer page) {
		List<NoticeDTO> noticeDTO = noticeService.findByPage(request, page);
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

	@GetMapping("/dates")
	public ResponseEntity<Object> findNoticesByDates(@RequestParam("startDate") String startDate,
		@RequestParam("endDate") String endDate) {
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
		List<NoticeDTO> noticeDTO = noticeService.findNoticesByDates(
			LocalDateTime.parse(startDate, formatter),
			LocalDateTime.parse(endDate, formatter)
		);
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}
}