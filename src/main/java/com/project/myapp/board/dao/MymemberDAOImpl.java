package com.project.myapp.board.dao;

import com.project.myapp.dto.TestMember;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class MymemberDAOImpl implements MymemberDAO {

    @Autowired
    SqlSession sqlSession;

    private static final String namespace = "com.project.myapp.board.dao.MemberMapper.";

    @Override
    public List<TestMember> memberList() {

        List<TestMember> list = this.sqlSession.selectList(namespace + "memberList");
        System.out.println("list = " + list);
        return list;
    }
}
