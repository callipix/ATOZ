package com.project.myapp.dto;

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

    public PageHandler2(int totalCnt , int page) {
        this(totalCnt, page, 5);
    }

    public PageHandler2(Integer totalCnt, Integer page, Integer pageSize) {
        this.totalCnt = totalCnt;
        this.page = page;
        this.pageSize = pageSize;

        totalPage = (int)Math.ceil((double)totalCnt /pageSize);
        beginPage = (page - 1)/ naviSize * naviSize +1;
        endPage = Math.min(beginPage + naviSize-1, totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public int getTotalCnt() {
        return totalCnt;
    }

    public void setTotalCnt(int totalCnt) {
        this.totalCnt = totalCnt;
    }

    public int getNaviSize() {
        return naviSize;
    }

    public void setNaviSize(int naviSize) {
        this.naviSize = naviSize;
    }

    public int getTotalPage() {
        return totalPage;
    }

    public void setTotalPage(int totalPage) {
        this.totalPage = totalPage;
    }

    public int getBeginPage() {
        return beginPage;
    }

    public void setBeginPage(int beginPage) {
        this.beginPage = beginPage;
    }

    public int getEndPage() {
        return endPage;
    }

    public void setEndPage(int endPage) {
        this.endPage = endPage;
    }

    public boolean isShowPrev() {
        return showPrev;
    }

    public void setShowPrev(boolean showPrev) {
        this.showPrev = showPrev;
    }

    public boolean isShowNext() {
        return showNext;
    }

    public void setShowNext(boolean showNext) {
        this.showNext = showNext;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getPageSize() {
        return pageSize;
    }

    public void setPageSize(int pageSize) {
        this.pageSize = pageSize;
    }

    @Override
    public String toString() {
        return "PageHandler{" +
                "totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                ", page=" + page +
                ", pageSize=" + pageSize +
                '}';
    }
}
