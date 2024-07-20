package com.project.myapp.register.dao;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class RegisterDAOImpl implements RegisterDAO {

    @Autowired
    SqlSession sqlSession;

    public static final String NAMESPACE = "com.project.myapp.register.dao.RegisterMapper.";

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
