package com.project.atoz.dto;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@Builder
@ToString
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
public class MemberDTO {
	@EqualsAndHashCode.Include
	private String id;
	private String name;
	private String phoneNo;
	private String zipcode;
	private String addressNormal;
	private String addressDetail;

}
