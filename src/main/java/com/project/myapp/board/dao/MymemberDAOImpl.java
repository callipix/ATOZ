package com.project.myapp.board.dao;

import com.project.myapp.dto.TestMember;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
@AllArgsConstructor
public class MymemberDAOImpl implements MymemberDAO {

    private final SqlSession sqlSession;
    private static final String namespace = "com.project.myapp.board.dao.MemberMapper.";

    @Override
    public List<TestMember> memberList() {

        List<TestMember> list = this.sqlSession.selectList(namespace + "memberList");
        return list;
    }

    @Override
    public int idCheck(String id){
        int result = this.sqlSession.selectOne(namespace + "idCheck", id);
        return result;
    }

    @Override
    public int addMember(TestMember member) {
        int result = this.sqlSession.insert(namespace + "save", member);
        return result;
    }

    @Override
    public TestMember getMember(String id) {
        TestMember member = this.sqlSession.selectOne(namespace + "getMember", id);
        return member;
    }
}
