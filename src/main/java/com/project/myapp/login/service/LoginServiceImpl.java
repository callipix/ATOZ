package com.project.myapp.login.service;

import com.project.myapp.login.dao.LoginDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class LoginServiceImpl implements LoginService{

    @Autowired
    private LoginDAO loginDAO;

    @Override
    public int loginCheck(String id , String password) {

        int result = 0;
        Map<String, String> loginCheckMap = new HashMap<String, String>();
        loginCheckMap.put("id", id);
        loginCheckMap.put("password", password);

        try {
            result = loginDAO.loginCheck(loginCheckMap);

        } catch (Exception e) {
            e.printStackTrace();
            return 0;
        }
        return result;
    }
}
