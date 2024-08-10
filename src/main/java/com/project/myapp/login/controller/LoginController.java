package com.project.myapp.login.controller;

import com.project.myapp.login.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.UnsupportedEncodingException;

@Controller
@RequestMapping("/login")
public class LoginController {

    @Autowired
    private LoginService loginService;

    @GetMapping("/logout")
    public String logOut(HttpSession session, HttpServletRequest request){
        session.invalidate();
        session = request.getSession();
        session.setAttribute("message","로그아웃이 완료되었습니다.");
        return "redirect:logoutSuccess";
    }
    @GetMapping("/loginForm")
    public String loginForm(){
        return "login/loginForm";
    }

    @PostMapping("/login")
    public String login(String id, String password, String toURL , boolean rememberId , HttpServletRequest request, HttpServletResponse response, Model m) throws UnsupportedEncodingException {

        HttpSession session = null;
        if(!loginCheck(id , password)){
            session = request.getSession();
            session.setAttribute("message", "id 또는 패스워드가 일치하지 않습니다.");
            return "redirect:/login/loginFailPage";
        }
        session = request.getSession();
        session.setAttribute("id", id);
        session.setAttribute("password", password);

        // 3.홈으로 이동
        toURL = toURL == null || toURL.equals("") ? "/" : toURL;
        return "redirect:" + toURL;
    }

    public boolean loginCheck(String id , String password){
        int result = 0;
            result = this.loginService.loginCheck(id, password);
        if(result == 1){
            return true;
        } else {
            return false;
        }
    }
}