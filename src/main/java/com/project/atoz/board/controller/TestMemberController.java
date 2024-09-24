package com.project.atoz.board.controller;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.project.atoz.board.service.MymemberService;
import com.project.atoz.dto.TestMember;

import lombok.RequiredArgsConstructor;

@Controller
@RequestMapping("/mymember")
@RequiredArgsConstructor
public class TestMemberController {

	private final MymemberService mymemberService;

	@GetMapping("/memberList")
	@ResponseBody
	public List<TestMember> memberList() {
		List<TestMember> list = this.mymemberService.memberList();
		return list;
	}

	@GetMapping("/idCheck")
	@ResponseBody
	public String idCheck(String id) {
		int result = this.mymemberService.idCheck(id);
		return String.valueOf(result);
	}

	@ResponseBody
	@PostMapping("/addMember")
	public TestMember addMember(TestMember member) {
		int result = this.mymemberService.addMember(member);
		return member;
	}

	@ResponseBody
	@PostMapping("/memDetail")
	public TestMember read(@RequestParam("memID") String memID) {
		TestMember getMember = this.mymemberService.getMember(memID);
		return getMember;
	}
}
