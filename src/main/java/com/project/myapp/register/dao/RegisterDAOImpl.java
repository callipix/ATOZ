package com.project.myapp.register.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.stereotype.Repository;

import com.project.myapp.dto.MemberDTO;
import com.project.myapp.dto.UserDTO;

import lombok.RequiredArgsConstructor;

@Repository
@RequiredArgsConstructor
public class RegisterDAOImpl implements RegisterDAO {

	private final SqlSession sqlSession;
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