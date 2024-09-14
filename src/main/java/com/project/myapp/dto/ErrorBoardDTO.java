package com.project.myapp.dto;

import java.util.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
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

}
