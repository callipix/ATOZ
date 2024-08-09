package com.project.myapp.board.service;

import com.project.myapp.dto.TestMember;

import java.util.List;

public interface MymemberService {

    List<TestMember> memberList();

    int idCheck(String id);

    int addMember(TestMember member);

    TestMember getMember(String id);
}
