package com.project.myapp.board.dao;

import com.project.myapp.dto.TestMember;

import java.util.List;

public interface MymemberDAO {

    List<TestMember> memberList();

    int idCheck(String id);

    int addMember(TestMember member);

    TestMember getMember(String id);
}
