package com.project.myapp.board.service;

import java.util.List;

import com.project.myapp.dto.TestMember;

public interface MymemberService {

	List<TestMember> memberList();

	int idCheck(String id);

	int addMember(TestMember member);

	TestMember getMember(String id);
}
