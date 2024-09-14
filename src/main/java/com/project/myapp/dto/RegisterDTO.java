package com.project.myapp.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class RegisterDTO {

	private UserDTO userDTO;
	private MemberDTO memberDTO;

	public RegisterDTO() {
	}

	public RegisterDTO(UserDTO userDTO, MemberDTO memberDTO) {
		this.userDTO = userDTO;
		this.memberDTO = memberDTO;
	}

}