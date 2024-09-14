package com.project.myapp.dto;

import java.util.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class CommentDTO {
	private Integer cno;
	private Integer bno;
	private Integer pcno;
	private String comment;
	private String commenter;
	private Date reg_date;
	private Date up_date;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		CommentDTO that = (CommentDTO)o;
		return Objects.equals(cno, that.cno) && Objects.equals(bno, that.bno) && Objects.equals(pcno, that.pcno)
			&& Objects.equals(comment, that.comment) && Objects.equals(commenter, that.commenter);
	}

	@Override
	public int hashCode() {
		return Objects.hash(cno, bno, pcno, comment, commenter);
	}

	public CommentDTO() {
	}

	public CommentDTO(Integer bno, Integer pcno, String comment, String commenter) {
		this.bno = bno;
		this.pcno = pcno;
		this.comment = comment;
		this.commenter = commenter;
	}

}
