package com.project.myapp.utiles;

import java.util.Arrays;
import java.util.List;

import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

public class CombinedValidator implements Validator {

	private final List<Validator> validators;

	public CombinedValidator(Validator... validators) {
		this.validators = Arrays.asList(validators);
	}

	@Override
	public boolean supports(Class<?> clazz) {
		for (Validator validator : validators) {
			if (validator.supports(clazz)) {
				return true;
			}
		}
		return false;
	}

	@Override
	public void validate(Object target, Errors errors) {
		for (Validator validator : validators) {
			if (validator.supports(target.getClass())) {
				validator.validate(target, errors);
			}
		}
	}
}
