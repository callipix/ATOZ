package com.project.myapp.dto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class RefreshDTO {

	private Long id;
	private String username;
	private String refresh;
	private String expiration;

}
