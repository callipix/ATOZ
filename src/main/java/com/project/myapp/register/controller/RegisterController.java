package com.project.myapp.register.controller;

import com.project.myapp.config.CombinedValidator;
import com.project.myapp.config.UserValidator;
import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;
import com.project.myapp.register.service.RegisterService;
import com.project.myapp.utiles.MemberValidator;
import lombok.AllArgsConstructor;
import org.jetbrains.annotations.NotNull;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
@AllArgsConstructor
public class RegisterController {

    private final RegisterService registerService;

    @InitBinder
    public void initBinder(@NotNull WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, false));
        binder.setValidator(new CombinedValidator(new UserValidator(), new MemberValidator()));
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public int idCheck(String id){
        Integer result = this.registerService.idCheck(id);
        return result;
    }
    @ResponseBody
    @PostMapping("/sendSMS")
    public String sendSMS(String phoneNo){

        String result = this.registerService.sendSMS(phoneNo);
        return result;
    }

    @PostMapping("/register")
    public String registerUser(@Valid UserDTO userDTO, BindingResult userResult, @Valid MemberDTO memberDTO, BindingResult memberResult , RedirectAttributes rdda, HttpSession session) throws Exception {

        if(userResult.hasErrors()) {
            return "registerForm";
        }
        if(memberResult.hasErrors()) {
            return "registerForm";
        }

        int result = this.registerService.insertUser(new RegisterDTO(userDTO, memberDTO));
        try {
            if(result >= 1){
                session.setAttribute("message", "회원가입에 성공하였습니다.");
            } else {
                session.setAttribute("message" ,"회원가입에 실패하였습니다.");
            }
            return "redirect:/resultPage";
        } catch (Exception e) {
            session.setAttribute("message" ,"서버 오류: " + e.getMessage());
            return "redirect:/resultPage";
        }
    }
}
