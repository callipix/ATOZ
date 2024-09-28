package com.project.atoz.dto;

import org.jetbrains.annotations.NotNull;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@NoArgsConstructor
@AllArgsConstructor
public class UserAuth {

	@NotNull
	private String id;
	@NotNull
	private String auth;

	public UserAuth(String id) {
		this.id = id;
	}
}
