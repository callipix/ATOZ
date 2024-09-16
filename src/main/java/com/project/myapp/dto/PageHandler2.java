package com.project.myapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class PageHandler2 {

	private int totalCnt;           // 전체 게시물 개수 -> 255
	private int naviSize = 10;      // 페이징바 사이즈(페이지 네비게이션 바) -> 미리 설정

	private int totalPage;          // 전체 페이지 개수 -> 26개
	private int beginPage;          // 페이지 네비게이션 바 시작페이지
	private int endPage;            // 페이지 네비게이션 바 끝 페이지
	private boolean showPrev;
	private boolean showNext;

	private int page;
	private int pageSize;

	public PageHandler2(int totalCnt, int page) {
		this(totalCnt, page, 5);
	}

	public PageHandler2(Integer totalCnt, Integer page, Integer pageSize) {
		this.totalCnt = totalCnt;
		this.page = page;
		this.pageSize = pageSize;

		totalPage = (int)Math.ceil((double)totalCnt / pageSize);
		beginPage = (page - 1) / naviSize * naviSize + 1;
		endPage = Math.min(beginPage + naviSize - 1, totalPage);
		showPrev = beginPage != 1;
		showNext = endPage != totalPage;
	}

}
