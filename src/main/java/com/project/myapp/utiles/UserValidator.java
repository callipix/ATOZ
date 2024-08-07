package com.project.myapp.utiles;

import com.project.myapp.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return UserDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        UserDTO userDTO = (UserDTO) target;

        String id = userDTO.getId();
        String password = userDTO.getPassword();
        String email = userDTO.getEmail();
        String nickName = userDTO.getNickName();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"password", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nickName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "required");

        if(id != null && id.isEmpty()){
            String idPattern = "^[a-zA-Z0-9]{8,12}$";
            Pattern pattern = Pattern.compile(idPattern , Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(id);
            if(!matcher.matches()){
                errors.rejectValue("id", "invalidId");
            }
        }
        if(password != null && password.isEmpty()){
            String passwordPattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{8,20}$";
            Pattern pattern = Pattern.compile(passwordPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(password);
            if(!matcher.matches()){
                errors.rejectValue("pwd", "invalidPassword");
            }
        }
        if(email != null && email.isEmpty()){
            String emailPattern = "^[a-zA-Z0-9._%+-]+@[a-zA-Z0-9.-]+\\.[a-zA-Z]{2,}$";
            Pattern pattern = Pattern.compile(emailPattern , Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(email);
            if(!matcher.matches()){
                errors.rejectValue("email", "invalidEmail");
            }
        }
        if(nickName != null && nickName.isEmpty()){
            String nickNamePattern = "^(?=.*[가-힣])?(?=.*[a-zA-Z])?(?=.*\\d)?[가-힣a-zA-Z\\d]{3,8}$";
            Pattern pattern = Pattern.compile(nickNamePattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(nickName);
            if(!matcher.matches()){
                errors.rejectValue("nickName", "invalidNickName");
            }
        }

    }
}
