package com.project.myapp.dto;

import java.util.Objects;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class MemberDTO {

	private String id;
	private String name;
	private String phoneNo;
	private String zipcode;
	private String addressNormal;
	private String addressDetail;

	@Override
	public boolean equals(Object o) {
		if (this == o)
			return true;
		if (o == null || getClass() != o.getClass())
			return false;
		MemberDTO memberDTO = (MemberDTO)o;
		return Objects.equals(id, memberDTO.id) && Objects.equals(name, memberDTO.name) && Objects.equals(phoneNo,
			memberDTO.phoneNo);
	}

	@Override
	public int hashCode() {
		return Objects.hash(id, name, phoneNo);
	}

	public MemberDTO() {
	}

	public MemberDTO(String id, String name, String phoneNo) {
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
	}

	public MemberDTO(String id, String name, String phoneNo, String zipcode, String addressNormal,
		String addressDetail) {
		this.id = id;
		this.name = name;
		this.phoneNo = phoneNo;
		this.zipcode = zipcode;
		this.addressNormal = addressNormal;
		this.addressDetail = addressDetail;
	}

}
