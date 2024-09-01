package com.project.myapp.board.service;

import com.project.myapp.dto.TestMember;
import com.project.myapp.board.dao.MymemberDAO;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
@RequiredArgsConstructor
public class MymemberServiceImpl implements MymemberService {
    private final MymemberDAO mymemberDAO;

    @Override
    public List<TestMember> memberList() {
        List<TestMember> list = mymemberDAO.memberList();
        System.out.println("MymemberServiceImpl list = " + list);
        return list;
    }

    @Override
    public int idCheck(String id) {
        int result = this.mymemberDAO.idCheck(id);
        System.out.println("result = " + result);
        return result;
    }

    @Override
    public int addMember(TestMember member) {
        System.out.println("BEFORE member = " + member);
        int result = this.mymemberDAO.addMember(member);
        System.out.println("AFTER member = " + member);
        System.out.println("AFTER result = " + result);
        return result;
    }

    @Override
    public TestMember getMember(String id) {
        System.out.println("BEFORE memberID = " + id);
        TestMember member = this.mymemberDAO.getMember(id);
        System.out.println("AFTER member INFO = " + member);
        return member;
    }


}
