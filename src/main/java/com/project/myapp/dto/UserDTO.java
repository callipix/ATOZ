package com.project.myapp.dto;

import lombok.*;

import java.util.Date;

@Getter
@Setter
@ToString
@NoArgsConstructor
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