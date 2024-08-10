package com.project.myapp.utiles;

import com.project.myapp.dto.MemberDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class MemberValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return MemberDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        MemberDTO memberDTO = (MemberDTO) target;

        String name = memberDTO.getName();
        String phoneNo = memberDTO.getPhoneNo();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phoneNo", "required");

        if(name != null && name.isEmpty()){
            String namePattern = "^[가-힣a-zA-Z]{3,8}$";
            Pattern pattern = Pattern.compile(namePattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(name);
            if(!matcher.matches()){
                errors.rejectValue("name", "invalidName");
            }
        }
        if(phoneNo != null && phoneNo.isEmpty()){
            String phoneNoPattern = "^01[0-9]-\\d{3,4}-\\d{4}$";
            Pattern pattern = Pattern.compile(phoneNoPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(phoneNo);
            if(!matcher.matches()){
                errors.rejectValue("phoneNo", "invalidPhoneNo");
            }
        }

    }
}