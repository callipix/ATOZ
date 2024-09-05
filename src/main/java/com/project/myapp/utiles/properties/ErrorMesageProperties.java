package com.project.myapp.utiles.properties;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import lombok.Getter;

@Getter
@Configuration
@PropertySource("classpath:error_message.properties")
public class ErrorMesageProperties {

	@Value("${required.userDTO.id}")
	private String errorId;
	@Value("${required.userDTO.password}")
	private String errorPassword;
	@Value("${required.userDTO.email}")
	private String errorEmail;
	@Value("${required.userDTO.nickName}")
	private String errorNickname;
	@Value("${required.userDTO.name}")
	private String errorName;
	@Value("${required.userDTO.phoneNo}")
	private String errorPhoneNo;
	@Value("${invalidLength.id}")
	private String errorInvalidLengthId;
	@Value("${invalidLength.password}")
	private String errorInvalidLengthPassword;
	@Value("${invalidLength.nickName}")
	private String errorInvalidLengthNickname;

}
