package com.project.atoz.dto;

import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
@EqualsAndHashCode
public class CommentDTO {
	private Integer cno;
	private Integer bno;
	private Integer pcno;
	private String comment;
	private String commenter;

	@EqualsAndHashCode.Exclude
	private Date reg_date;

	@EqualsAndHashCode.Exclude
	private Date up_date;

	public CommentDTO(Integer bno, Integer pcno, String comment, String commenter) {
		this.bno = bno;
		this.pcno = pcno;
		this.comment = comment;
		this.commenter = commenter;
	}

}
