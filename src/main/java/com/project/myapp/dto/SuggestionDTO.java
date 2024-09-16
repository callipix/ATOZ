package com.project.myapp.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class SuggestionDTO {

	private int sno;
	private String writer;
	private String password;
	private String content;
	private Date regDate;
	private Date upDate;

}
