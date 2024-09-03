package com.project.myapp.dto;

import java.util.Date;

import lombok.Builder;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Builder
@Getter
@Setter
@ToString
@RequiredArgsConstructor
public class UserDTO {

	private String id;
	private String password;
	private String nickName;
	private String email;

	private String role;
	private String type;

	private String provider;
	private String providerId;

	private String status;
	private String profile;

	private Date createDate;

}