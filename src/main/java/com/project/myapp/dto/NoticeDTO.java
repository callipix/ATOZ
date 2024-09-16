package com.project.myapp.dto;

import java.util.Date;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoticeDTO {
	@EqualsAndHashCode.Include
	private long id;
	private String title;
	private String content;
	private String who;
	private Date create_date;
	private Date update_date;

}