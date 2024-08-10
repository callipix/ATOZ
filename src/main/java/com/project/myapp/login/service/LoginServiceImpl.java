package com.project.myapp.login.service;

import com.project.myapp.login.dao.LoginDAO;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@AllArgsConstructor
public class LoginServiceImpl implements LoginService{

    private final LoginDAO loginDAO;

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