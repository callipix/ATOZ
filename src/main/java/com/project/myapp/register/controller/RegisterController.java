package com.project.myapp.register.controller;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;
import com.project.myapp.dto.UserMemberWrapper;
import com.project.myapp.register.service.RegisterService;
import com.project.myapp.utiles.UserValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;
import java.text.SimpleDateFormat;
import java.util.Date;

@Controller
public class RegisterController {

    @Autowired
    private RegisterService registerService;

    @InitBinder
    public void initBinder(WebDataBinder binder) {
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyy-MM-dd");
        binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
        binder.setValidator(new UserValidator());
    }

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

    @GetMapping("/form")
    public String showForm(Model model){
        model.addAttribute("register", new RegisterDTO());
        return "registerForm";
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("registerDTO") RegisterDTO registerDTO, BindingResult bindingResult, RedirectAttributes rdda, HttpSession session) throws Exception {

        System.out.println("registerDTO = " + registerDTO);

        if(bindingResult.hasErrors()) {
            return "registerForm";
        }
        if(bindingResult.hasErrors()) {
            return "registerForm";
        }

        int result = this.registerService.insertUser(new RegisterDTO(registerDTO.getUserDTO(), registerDTO.getMemberDTO()));

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
