package com.project.myapp.register.dao;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.RegisterDTO;
import com.project.myapp.dto.UserDTO;

public interface RegisterDAO {

    public int idCheck(String id);

    public int insertUser(UserDTO userDTO);

    public int insertMember(MemberDTO memberDTO);

}
