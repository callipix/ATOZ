package com.project.myapp.utiles;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.myapp.dto.UserDTO;
import com.project.myapp.utiles.properties.ErrorMesageProperties;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class UserValidator implements Validator {

	public ErrorMesageProperties errorMesageProperties;

	@Override
	public boolean supports(Class<?> clazz) {
		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {
		log.info("target = {}", target);

		UserDTO userDTO = (UserDTO)target;

		String id = userDTO.getId();
		String password = userDTO.getPassword();
		String email = userDTO.getEmail();
		String nickName = userDTO.getNickName();

		String idPattern = "^[a-zA-Z0-9]+$";
		String passwordPattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]+$";
		String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		String nickNamePattern = "^(?=.*[가-힣])?(?=.*[a-zA-Z])?(?=.*\\d)?[가-힣a-zA-Z\\d]+$";

		// String idPattern = "^[a-zA-Z0-9]$";
		// String passwordPattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]$";
		// String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
		// String nickNamePattern = "^(?=.*[가-힣])?(?=.*[a-zA-Z])?(?=.*\\d)?[가-힣a-zA-Z\\d]$";

		Pattern pattern = Pattern.compile(idPattern, Pattern.CASE_INSENSITIVE);
		Pattern pattern2 = Pattern.compile(passwordPattern, Pattern.CASE_INSENSITIVE);
		Pattern pattern3 = Pattern.compile(emailPattern, Pattern.CASE_INSENSITIVE);
		Pattern pattern4 = Pattern.compile(nickNamePattern, Pattern.CASE_INSENSITIVE);

		Matcher matcherId = pattern.matcher(id);
		Matcher matcherPassword = pattern2.matcher(password);
		Matcher matcherEmail = pattern3.matcher(email);
		Matcher matcherNickname = pattern4.matcher(nickName);

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required", errorMesageProperties.getErrorId());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required",
			errorMesageProperties.getErrorPassword());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "nickName", "required",
			errorMesageProperties.getErrorNickname());
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "email", "required", errorMesageProperties.getErrorEmail());

		if (id.length() < 8 || id.length() > 12) {
			errors.rejectValue("id", "invalidLength", new String[] {"8", "12"},
				errorMesageProperties.getErrorInvalidLengthNickname());
		}
		if (password.length() < 8 || password.length() > 20) {
			errors.rejectValue("password", "invalidLength", new String[] {"8", "20"},
				errorMesageProperties.getErrorInvalidLengthPassword());
		}
		if (nickName.length() < 3 || nickName.length() > 8) {
			errors.rejectValue("nickName", "invalidLength", new String[] {"3", "8"},
				errorMesageProperties.getErrorInvalidLengthNickname());
		}

		if (!matcherId.matches()) {
			errors.rejectValue("id", "invalidId");
		}
		if (!matcherPassword.matches()) {
			errors.rejectValue("password", "invalidPassword", null);
		}
		if (!matcherEmail.matches()) {
			errors.rejectValue("email", "invalidEmail", null);
		}
		if (!matcherNickname.matches()) {
			errors.rejectValue("nickName", "invalidNickName", null);
		}
	}
}