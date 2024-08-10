package com.project.myapp.board.service;

import com.project.myapp.dto.TestMember;
import com.project.myapp.board.dao.MymemberDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MymemberServiceImpl implements MymemberService {

    @Autowired
    MymemberDAO mymemberDAO;

    @Override
    public List<TestMember> memberList() {
        List<TestMember> list = mymemberDAO.memberList();
        return list;
    }

    @Override
    public int idCheck(String id) {
        int result = this.mymemberDAO.idCheck(id);
        return result;
    }

    @Override
    public int addMember(TestMember member) {
        int result = this.mymemberDAO.addMember(member);
        return result;
    }

    @Override
    public TestMember getMember(String id) {
        TestMember member = this.mymemberDAO.getMember(id);
        return member;
    }


}
