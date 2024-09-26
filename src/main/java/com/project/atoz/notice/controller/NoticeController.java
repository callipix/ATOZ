package com.project.atoz.notice.controller;

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

import com.project.atoz.dto.NoticeDTO;
import com.project.atoz.dto.PageHandler;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.notice.annotation.Timer;
import com.project.atoz.notice.annotation.Timer2;
import com.project.atoz.notice.service.NoticeService;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/notices")
public class NoticeController {

	private final NoticeService noticeService;

	@Timer2
	@GetMapping("")
	public ResponseEntity<Object> findAll() {
		List<NoticeDTO> noticeDTO = noticeService.getAllNotices();
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

	@Timer
	@GetMapping("/findAllByEhcache")
	public ResponseEntity<Object> findAllByEhcache() {
		List<NoticeDTO> noticeDTO = noticeService.findAllByEhcache();
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

	@Timer
	@GetMapping("/{page}")
	public ResponseEntity<Object> findByPage(HttpServletRequest request, @PathVariable("page") Integer page) throws
		InterruptedException {
		List<NoticeDTO> noticeDTO = noticeService.findByPage(request, page);
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

//	@GetMapping("/dates")
//	public ResponseEntity<Object> findNoticesByDates(@RequestParam("startDate") String startDate,
//		@RequestParam("endDate") String endDate) {
//		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
//		List<NoticeDTO> noticeDTO = noticeService.findNoticesByDates(
//			LocalDateTime.parse(startDate, formatter),
//			LocalDateTime.parse(endDate, formatter)
//		);
//		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
//	}

	@Timer
	@GetMapping("/count")
	public ResponseEntity<Integer> getNoticesCount(String option, String keyword) {
		SearchCondition sc = new SearchCondition();
		sc.setOption(option);
		sc.setKeyword(keyword);
		Integer totalNotice = this.noticeService.getSearchNoticeResultCount(sc);
		return new ResponseEntity<>(totalNotice, HttpStatus.OK);
	}

	@Timer
	@GetMapping(value = "/totalCount", produces = "application/json;charset=utf-8")
	public ResponseEntity<Integer> getNoticeTotalCount() {
		Integer totalNotice = this.noticeService.getNoticeTotalCount();
		return new ResponseEntity<>(totalNotice, HttpStatus.OK);
	}

	// @Timer	// 50회 반복 메서드 속도 측정
	@Timer2        // 1번 반복 -> 부하테스트 측정
	@GetMapping("/noticeList")
	public ResponseEntity<Object> getNoticeList(String option, String keyword, Integer page, Integer pageSize) {

		SearchCondition sc = isParameterDefault(option, keyword, page, pageSize);
		List<NoticeDTO> noticeDTO = this.noticeService.noticeSearchSelectPage2(sc);
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);
	}

	// @Timer // 50회 반복 메서드 속도 측정
	@Timer2   // 1번 반복 -> 부하테스트 측정
	@GetMapping("/noticeListByEhcache")
	public ResponseEntity<Object> getNoticeListByEhcache(String option, String keyword, Integer page,
		Integer pageSize) {

		log.info("option = {}", option);
		log.info("keyword = {}", keyword);
		log.info("page = {}", page);
		log.info("pageSize = {}", pageSize);

		SearchCondition sc = isParameterDefault(option, keyword, page, pageSize);
		List<NoticeDTO> noticeDTO = this.noticeService.getNoticeListByEhcache(sc);
		return new ResponseEntity<>(noticeDTO, HttpStatus.OK);

	}

	private SearchCondition isParameterDefault(String option, String keyword, Integer page, Integer pageSize) {
		if (page == null || page == 0) {
			page = 1;
		}
		if (pageSize == null || pageSize == 0) {
			pageSize = 10;
		}
		if (option.isEmpty() || option == null) {
			option = "";
		}
		if (keyword.isEmpty() || keyword == null) {
			keyword = "";
		}
		SearchCondition sc = new SearchCondition();
		sc.setOption(option);
		sc.setKeyword(keyword);
		sc.setPage(page);
		sc.setPageSize(pageSize);

		int totalCnt = this.noticeService.getSearchNoticeResultCount(sc);
		PageHandler pageHandler = new PageHandler(totalCnt, sc);
		return sc;
	}

}