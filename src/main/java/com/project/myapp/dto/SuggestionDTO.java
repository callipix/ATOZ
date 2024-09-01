package com.project.myapp.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@NoArgsConstructor
@ToString
public class SuggestionDTO {

	private int sno;
	private String writer;
	private String password;
	private String content;
	private Date regDate;
	private Date upDate;

}
