package com.project.myapp.register.dao;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.UserDTO;
import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

@Repository
@AllArgsConstructor
public class RegisterDAOImpl implements RegisterDAO {

    private final SqlSession sqlSession;
    private static final String NAMESPACE = "com.project.myapp.register.dao.RegisterMapper.";

    @Override
    public int idCheck(String id) {
        int result = this.sqlSession.selectOne(NAMESPACE + "idCheck", id);
        return result;
    }

    @Override
    public int insertUser(UserDTO userDTO) {
        int result = this.sqlSession.insert(NAMESPACE + "insertUser", userDTO);
        return result;
    }

    @Override
    public int insertMember(MemberDTO memberDTO) {
        int result = this.sqlSession.insert(NAMESPACE + "insertMember", memberDTO);
        return result;
    }
}