package com.project.myapp.login.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Map;

@Repository
public class LoginDAOImpl implements LoginDAO {

    @Autowired
    private SqlSession sqlSession;

    private static final String namespace = "com.project.myapp.login.dao.LoginMapper.";

    @Override
    public int loginCheck(Map<String, String> map){
        int result = 0;
        System.out.println("map = " + map);
            result = sqlSession.selectOne(namespace+"loginCheck", map);
        System.out.println("loginCheck result = " + result);
        return result;
    }
}
