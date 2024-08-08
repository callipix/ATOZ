package com.project.myapp.board.controller;

import com.project.myapp.board.service.MymemberService;
import com.project.myapp.dto.TestMember;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

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

}
