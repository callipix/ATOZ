package com.project.myapp.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
public class TestMember {

	private String MEM_ID;
	private String MEM_PASS;
	private String MEM_NAME;
	private String MEM_TEL;
	private String MEM_ADDR;
	private String MEM_PHOTO;

}
