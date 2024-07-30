package com.project.myapp.dto;

import java.util.Date;

public class ErrorBoardDTO {
    private int errBno;
    private String errCode;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private int commentCnt;
    private Date regDate;
    private Date upDate;
    private int categoryNo;
    private String errBoardThum;

    public ErrorBoardDTO(){}

    public ErrorBoardDTO(String errCode, String title, String content, String writer) {
        this.errCode = errCode;
        this.title = title;
        this.content = content;
        this.writer = writer;
    }
    public ErrorBoardDTO(String errCode, String title, String content, String writer, String errBoardThum) {
        this.errCode = errCode;
        this.title = title;
        this.content = content;
        this.writer = writer;
        this.errBoardThum = errBoardThum;
    }

    public int getErrBno() {
        return errBno;
    }

    public void setErrBno(int errBno) {
        this.errBno = errBno;
    }

    public String getErrCode() {
        return errCode;
    }

    public void setErrCode(String errCode) {
        this.errCode = errCode;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getWriter() {
        return writer;
    }

    public void setWriter(String writer) {
        this.writer = writer;
    }

    public int getViewCnt() {
        return viewCnt;
    }

    public void setViewCnt(int viewCnt) {
        this.viewCnt = viewCnt;
    }

    public int getCommentCnt() {
        return commentCnt;
    }

    public void setCommentCnt(int commentCnt) {
        this.commentCnt = commentCnt;
    }

    public Date getRegDate() {
        return regDate;
    }

    public void setRegDate(Date regDate) {
        this.regDate = regDate;
    }

    public Date getUpDate() {
        return upDate;
    }

    public void setUpDate(Date upDate) {
        this.upDate = upDate;
    }

    public int getCategoryNo() {
        return categoryNo;
    }

    public void setCategoryNo(int categoryNo) {
        this.categoryNo = categoryNo;
    }

    public String getErrBoardThum() {
        return errBoardThum;
    }

    public void setErrBoardThum(String errBoardThum) {
        this.errBoardThum = errBoardThum;
    }

    @Override
    public String toString() {
        return "ErrorBoardDTO{" +
                "errBno=" + errBno +
                ", errCode='" + errCode + '\'' +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", viewCnt=" + viewCnt +
                ", commentCnt=" + commentCnt +
                ", regDate=" + regDate +
                ", upDate=" + upDate +
                ", categoryNo=" + categoryNo +
                ", errBoardThum='" + errBoardThum + '\'' +
                '}';
    }
}
