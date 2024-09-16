package com.project.myapp.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@NoArgsConstructor
public class RefreshDTO {

	private Long id;
	private String username;
	private String refresh;
	private String expiration;

}
