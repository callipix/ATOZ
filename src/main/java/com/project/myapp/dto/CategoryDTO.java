package com.project.myapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class CategoryDTO {

	private int categoryNo;
	private String categoryName;
	private int categoryPickBno;

}
