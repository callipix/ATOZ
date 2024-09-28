package com.project.atoz.dto;

import java.util.Date;

import org.jetbrains.annotations.NotNull;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class BoardDTO {

	private int rownum;
	@EqualsAndHashCode.Include
	private Integer bno;
	private final Integer categoryNo = 1;
	@NotNull
	private String title;
	@NotNull
	private String content;
	@NotNull
	private String writer;
	private int viewCnt;
	private int commentCnt;
	private Date regDate;
	private Date upDate;

	public BoardDTO() {
		this("", "", "");
	}

	public BoardDTO(String title, String content, String writer) {
		this.title = title;
		this.content = content;
		this.writer = writer;
	}
}
