package com.project.myapp.login.dao;

import lombok.AllArgsConstructor;
import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
@AllArgsConstructor
public class LoginDAOImpl implements LoginDAO {

    private final SqlSession sqlSession;
    private static final String namespace = "com.project.myapp.login.dao.LoginMapper.";

    @Override
    public int loginCheck(Map<String, String> map){
        int result = 0;
            result = sqlSession.selectOne(namespace+"loginCheck", map);
        return result;
    }
}