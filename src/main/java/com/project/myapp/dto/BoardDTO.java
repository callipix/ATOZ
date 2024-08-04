package com.project.myapp.dto;

import java.util.Date;
import java.util.Objects;

public class BoardDTO {

    private int rownum;
    private Integer bno;
    private final Integer categoryNo = 1;
    private String title;
    private String content;
    private String writer;
    private int viewCnt;
    private int commentCnt;
    private Date regDate;
    private Date upDate;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        BoardDTO boardDTO = (BoardDTO) o;
        return Objects.equals(bno, boardDTO.bno) && Objects.equals(categoryNo, boardDTO.categoryNo) && Objects.equals(title, boardDTO.title) && Objects.equals(content, boardDTO.content) && Objects.equals(writer, boardDTO.writer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(bno, categoryNo, title, content, writer);
    }

    public BoardDTO() {
        this("","","");
    }

    public BoardDTO(String title, String content, String writer) {
        this.title = title;
        this.content = content;
        this.writer = writer;
    }

    public Integer getCategoryNo() {
        return categoryNo;
    }

    public int getRownum() {
        return rownum;
    }

    public void setRownum(int rownum) {

        this.rownum = rownum;
    }

    public Integer getBno() {
        return bno;
    }

    public void setBno(Integer bno) {
        this.bno = bno;
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

    @Override
    public String toString() {
        return "BoardDTO{" +
                "rownum=" + rownum +
                ", bno=" + bno +
                ", categoryNo=" + categoryNo +
                ", title='" + title + '\'' +
                ", content='" + content + '\'' +
                ", writer='" + writer + '\'' +
                ", viewCnt=" + viewCnt +
                ", commentCnt=" + commentCnt +
                ", regDate=" + regDate +
                ", upDate=" + upDate +
                '}';
    }
}
