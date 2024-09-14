package com.project.myapp.dto;

import java.util.Date;
import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class NoticeDTO {
	private long id;
	private String title;
	private String content;
	private String who;
	private Date create_date;
	private Date update_date;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		NoticeDTO noticeDTO = (NoticeDTO)o;
		return id == noticeDTO.id && Objects.equals(title, noticeDTO.title) && Objects.equals(content,
			noticeDTO.content) && Objects.equals(who, noticeDTO.who);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, title, content, who);
	}

	public NoticeDTO(long id, String title, String content, String who, Date create_date, Date update_date) {
		this.id = id;
		this.title = title;
		this.content = content;
		this.who = who;
		this.create_date = create_date;
		this.update_date = update_date;
	}

}