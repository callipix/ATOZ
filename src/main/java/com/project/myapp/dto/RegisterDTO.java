package com.project.myapp.dto;

public class RegisterDTO {

	private UserDTO userDTO;
	private MemberDTO memberDTO;

	public RegisterDTO() {
	}

	public RegisterDTO(UserDTO userDTO, MemberDTO memberDTO) {
		this.userDTO = userDTO;
		this.memberDTO = memberDTO;
	}

	public UserDTO getUserDTO() {
		return userDTO;
	}

	public void setUserDTO(UserDTO userDTO) {
		this.userDTO = userDTO;
	}

	public MemberDTO getMemberDTO() {
		return memberDTO;
	}

	public void setMemberDTO(MemberDTO memberDTO) {
		this.memberDTO = memberDTO;
	}

	@Override
	public String toString() {
		return "RegisterDTO{" +
			"userDTO=" + userDTO +
			", memberDTO=" + memberDTO +
			'}';
	}
}