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
        System.out.println("MymemberServiceImpl list = " + list);
        return list;
    }
}
