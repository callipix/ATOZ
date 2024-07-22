package com.project.myapp.dto;

public class PageHandler {

    private int totalCnt;           // 전체 게시물 개수 -> 255
    private int naviSize = 8;      // 페이징바 사이즈(페이지 네비게이션 바) -> 미리 설정
    private int totalPage;          // 전체 페이지 개수 -> 26개
    private int beginPage;          // 페이지 네비게이션 바 시작페이지
    private int endPage;            // 페이지 네비게이션 바 끝 페이지
    private boolean showPrev;
    private boolean showNext;

    private SearchCondition sc;

    public PageHandler(int totalCnt, SearchCondition sc) {
        this.totalCnt = totalCnt;
        this.sc = sc;

        doPaging(totalCnt,sc);
    }
    public void doPaging(int totalCnt, SearchCondition sc) {

        this.totalCnt = totalCnt;

        totalPage = (int)Math.ceil((double)totalCnt / sc.getPageSize());

        beginPage = (sc.getPage() - 1) / naviSize * naviSize + 1;
        endPage = Math.min( beginPage + naviSize -1 , totalPage);
        showPrev = beginPage != 1;
        showNext = endPage != totalPage;
    }

    public SearchCondition getSc() {
        return sc;
    }

    public void setSc(SearchCondition sc) {
        this.sc = sc;
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

    public void print(){
        System.out.println("page = " + sc.getPage());
        System.out.println(showPrev ? "[PREV] " : " ");
        for(int i = beginPage ; i <= endPage; i++){
            System.out.print(i + " ");
        }
        System.out.println(showNext ? "[NEXT] " : "");
    }

    @Override
    public String toString() {
        return "PagingHandler{" +
                "sc=" + sc +
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
