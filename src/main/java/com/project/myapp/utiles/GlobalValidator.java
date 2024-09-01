package com.project.myapp.utiles;

import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import com.project.myapp.dto.UserDTO;

public class GlobalValidator implements Validator {
	@Override
	public boolean supports(Class<?> clazz) {

		return UserDTO.class.isAssignableFrom(clazz);
	}

	@Override
	public void validate(Object target, Errors errors) {

		UserDTO user = (UserDTO)target;

		String id = user.getId();

		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "id", "required");
		ValidationUtils.rejectIfEmptyOrWhitespace(errors, "password", "required");

	}
}
