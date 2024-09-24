package com.project.atoz.dto;

import java.io.Serializable;
import java.util.Date;

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
public class UserDTO implements Serializable {

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