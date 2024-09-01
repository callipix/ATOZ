package com.project.myapp.board.dao;

import java.util.List;

import com.project.myapp.dto.TestMember;

public interface MymemberDAO {

	List<TestMember> memberList();

	int idCheck(String id);

	int addMember(TestMember member);

	TestMember getMember(String id);
}
