package com.project.myapp.dto;

public class PageHandler {

    private int page = 1;               // 현재 페이지
    private int pageSize = 10;           // 한 페이지의 크기
    private int totalCnt;           // 전체 게시물 개수 -> 255
    private int naviSize = 8;      // 페이징바 사이즈(페이지 네비게이션 바) -> 미리 설정
    private int totalPage;          // 전체 페이지 개수 -> 26개
    private int beginPage;          // 페이지 네비게이션 바 시작페이지
    private int endPage;            // 페이지 네비게이션 바 끝 페이지

    private boolean showPrev;
    private boolean showNext;

    public PageHandler(int totalCnt, int page){
        this(totalCnt,page,10);
    }
    public PageHandler(int totalCnt, int page, int pageSize){
        this.totalCnt = totalCnt;
        totalPage = (int)Math.ceil((double)totalCnt / pageSize);
        beginPage = (page - 1) / naviSize * naviSize + 1;
        endPage = Math.min( beginPage + naviSize -1 , totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
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

    @Override
    public String toString() {
        return "PagingHandler{" +
                "page=" + page +
                ", pageSize=" + pageSize +
                ", totalCnt=" + totalCnt +
                ", naviSize=" + naviSize +
                ", totalPage=" + totalPage +
                ", beginPage=" + beginPage +
                ", endPage=" + endPage +
                ", showPrev=" + showPrev +
                ", showNext=" + showNext +
                '}';
    }
}
