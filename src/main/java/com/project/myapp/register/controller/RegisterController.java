package com.project.myapp.register.controller;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;
import com.project.myapp.register.service.RegisterService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @GetMapping("/idCheck")
    @ResponseBody
    public int idCheck(String id){
        System.out.println("inputId = " + id);
        Integer result = this.registerService.idCheck(id);
        System.out.println("result = " + result);
        return result;
    }
    @ResponseBody
    @PostMapping("/sendSMS")
    public String sendSMS(String phoneNo){

        String result = this.registerService.sendSMS(phoneNo);
        System.out.println("result = " + result);
        return result;
    }
    @PostMapping("/register")
    public String registerUser(UserDTO userDTO, MemberDTO memberDTO, RedirectAttributes rdda, HttpSession session) throws Exception {

        int result = this.registerService.insertUser(new RegisterDTO(userDTO, memberDTO));

        System.out.println("result = " + result);
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
