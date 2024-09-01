package com.project.myapp.dto;

import java.util.Objects;

public class UserMemberWrapper {

	private UserDTO userDTO;
	private MemberDTO memberDTO;

	public UserMemberWrapper(UserDTO userDTO, MemberDTO memberDTO) {
		this.userDTO = userDTO;
		this.memberDTO = memberDTO;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		UserMemberWrapper that = (UserMemberWrapper)o;
		return Objects.equals(userDTO, that.userDTO) && Objects.equals(memberDTO, that.memberDTO);
	}

	@Override
	public int hashCode() {
		return Objects.hash(userDTO, memberDTO);
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
		return "UserMemberWrapper{" +
			"userDTO=" + userDTO +
			", memberDTO=" + memberDTO +
			'}';
	}
}
