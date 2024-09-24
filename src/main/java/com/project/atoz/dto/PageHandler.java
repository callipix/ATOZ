package com.project.atoz.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Getter
@Setter
@ToString
public class PageHandler {

	private int totalCnt;           // 전체 게시물 개수 -> 255
	private int naviSize = 10;      // 페이징바 사이즈(페이지 네비게이션 바) -> 미리 설정
	private int totalPage;          // 전체 페이지 개수 -> 26개
	private int beginPage;          // 페이지 네비게이션 바 시작페이지
	private int endPage;            // 페이지 네비게이션 바 끝 페이지
	private boolean showPrev;
	private boolean showNext;

	private int page;
	private int pageSize;

	private SearchCondition sc;

	public PageHandler(int totalCnt, Integer page) {

		this(totalCnt, new SearchCondition(page, 10));
	}

	public PageHandler(Integer totalCnt, Integer page, Integer pageSize) {
		this.totalCnt = totalCnt;
		this.page = page;
		this.pageSize = pageSize;

		totalPage = (int)Math.ceil((double)totalCnt / pageSize);
		beginPage = page - 1 / naviSize * naviSize + 1;
		endPage = Math.min(beginPage + naviSize - 1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

	public PageHandler(int totalCnt, SearchCondition sc) {
		this.totalCnt = totalCnt;
		this.sc = sc;

		doPaging(totalCnt, sc);
	}

	public void doPaging(int totalCnt, SearchCondition sc) {

		this.totalCnt = totalCnt;
		this.totalPage = totalCnt / sc.getPageSize() + (totalCnt % sc.getPageSize() == 0 ? 0 : 1);
		this.sc.setPage(Math.min(sc.getPage(), totalPage));
		this.beginPage = (this.sc.getPage() - 1) / naviSize * naviSize + 1; // 11 -> 11, 10 -> 1, 15->11. 따로 떼어내서 테스트
		this.endPage = Math.min(beginPage + naviSize - 1, totalPage);
		this.showPrev = beginPage != 1;
		this.showNext = endPage != totalPage;
	}

	public void print() {
		log.info("page = {}", sc.getPage());
		log.info(showPrev ? "[PREV] " : " ");

		StringBuilder pageNumbers = new StringBuilder();
		for (int i = beginPage; i <= endPage; i++) {
			pageNumbers.append(i).append(" ");
		}
		log.info(pageNumbers.toString());

		log.info(showNext ? "[NEXT] " : "");

	}
}