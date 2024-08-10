package com.project.myapp.board.controller;

import com.project.myapp.board.service.MymemberService;
import com.project.myapp.dto.TestMember;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/mymember")
public class TestMemberController {

    @Autowired
    MymemberService mymemberService;

    @GetMapping("/memberList")
    @ResponseBody
    public List<TestMember> memberList(){
        List<TestMember> list = this.mymemberService.memberList();
        return list;
    }

    @GetMapping("/idCheck")
    @ResponseBody
    public String idCheck(String id){
        int result = this.mymemberService.idCheck(id);
        return String.valueOf(result);
    }
    @ResponseBody
    @PostMapping("/addMember")
    public TestMember addMember(TestMember member){
        int result = this.mymemberService.addMember(member);
        return member;
    }
    @ResponseBody
    @PostMapping("/memDetail")
    public TestMember read(@RequestParam("memID") String memID){
        TestMember getMember = this.mymemberService.getMember(memID);
        return getMember;
    }
}
