package com.project.atoz.board.dao;

import java.util.List;

import com.project.atoz.dto.TestMember;

public interface MymemberDAO {

	List<TestMember> memberList();

	int idCheck(String id);

	int addMember(TestMember member);

	TestMember getMember(String id);
}
