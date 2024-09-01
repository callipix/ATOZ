package com.project.myapp.board.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.project.myapp.board.dao.MymemberDAO;
import com.project.myapp.dto.TestMember;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Service
@RequiredArgsConstructor
public class MymemberServiceImpl implements MymemberService {
	private final MymemberDAO mymemberDAO;

	@Override
	public List<TestMember> memberList() {
		List<TestMember> list = mymemberDAO.memberList();
		log.info("MymemberServiceImpl list = {}", list);
		return list;
	}

	@Override
	public int idCheck(String id) {
		int result = this.mymemberDAO.idCheck(id);
		log.info("result = {}", result);
		return result;
	}

	@Override
	public int addMember(TestMember member) {
		log.info("BEFORE member =  {}", member);
		int result = this.mymemberDAO.addMember(member);
		log.info("AFTER member =  {}", member);
		log.info("AFTER result =  {}", result);
		return result;
	}

	@Override
	public TestMember getMember(String id) {
		log.info("BEFORE memberID = {}", id);
		TestMember member = this.mymemberDAO.getMember(id);
		log.info("AFTER member INFO = {}", member);
		return member;
	}

}
