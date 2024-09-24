package com.project.atoz.dto;

import lombok.*;

import java.sql.Timestamp;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class NoticeDTO {

	@EqualsAndHashCode.Include
	private long id;
	private String title;
	private String content;
	private String who;
	private Timestamp create_date;
	private Timestamp update_date;

}