package com.project.myapp.dto;

import java.util.Date;
import java.util.Objects;

public class ErrorBoardDTO {

	private int rownum;
	private int errBno;
	private String errCode;
	private String title;
	private String content;
	private String writer;
	private int viewCnt;
	private int commentCnt;
	private Date regDate;
	private Date upDate;
	private final int categoryNo = 2;
	private String errBoardThum;

	public ErrorBoardDTO() {
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		ErrorBoardDTO that = (ErrorBoardDTO)o;
		return errBno == that.errBno && Objects.equals(errCode, that.errCode) && Objects.equals(title, that.title)
			&& Objects.equals(content, that.content) && Objects.equals(writer, that.writer);
	}

	@Override
	public int hashCode() {
		return Objects.hash(errBno, errCode, title, content, writer);
	}

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

	public int getRownum() {
		return rownum;
	}

	public void setRownum(int rownum) {
		this.rownum = rownum;
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

	public String getErrBoardThum() {
		return errBoardThum;
	}

	public void setErrBoardThum(String errBoardThum) {
		this.errBoardThum = errBoardThum;
	}

	@Override
	public String toString() {
		return "ErrorBoardDTO{" +
			"rownum=" + rownum +
			", errBno=" + errBno +
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
