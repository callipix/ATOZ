package com.project.myapp.utiles;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;
import org.springframework.validation.Errors;
import org.springframework.validation.ValidationUtils;
import org.springframework.validation.Validator;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class UserValidator implements Validator {
    @Override
    public boolean supports(Class<?> clazz) {
        return RegisterDTO.class.isAssignableFrom(clazz);
    }

    @Override
    public void validate(Object target, Errors errors) {

        RegisterDTO registerDTO = (RegisterDTO) target;

        String id = registerDTO.getUserDTO().getId();
        String pwd = registerDTO.getUserDTO().getPassword();
        String email = registerDTO.getUserDTO().getEmail();
        String nickName = registerDTO.getUserDTO().getNickName();

        String name = registerDTO.getMemberDTO().getName();
        String phoneNo = registerDTO.getMemberDTO().getPhoneNo();

        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"id", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"pwd", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"nickName", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"name", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"email", "required");
        ValidationUtils.rejectIfEmptyOrWhitespace(errors,"phoneNo", "required");

        if(id != null && id.isEmpty()){
            String idPattern = "^[a-zA-Z0-9]{8,12}$";
            Pattern pattern = Pattern.compile(idPattern , Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(id);
            if(!matcher.matches()){
                errors.rejectValue("id", "invalidId");
            }
        }
        if(pwd != null && pwd.isEmpty()){
            String passwordPattern = "^(?=.*[a-zA-Z])[a-zA-Z0-9!@#$%^&*(),.?\":{}|<>]{8,20}$";
            Pattern pattern = Pattern.compile(passwordPattern, Pattern.CASE_INSENSITIVE);
            Matcher matcher = pattern.matcher(pwd);
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
