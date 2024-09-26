package com.project.atoz.errorboard.mapper;

import static org.junit.Assert.*;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.project.atoz.dto.ErrorBoardDTO;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ErrorBoardMapperImplTest {

	@Autowired
	private ErrorBoardMapper errorBoardMapper;
	@Autowired
	private SqlSession sqlSession;
	private static final String namespace = "com.project.myapp.errorboard.dao.ErrorBoardMapper.";

	@Test
	public void delete() {
		int errBno = 112;
		List<ErrorBoardDTO> deleteList = sqlSession.selectList(namespace + "getDeleteList", errBno);
		log.info("deleteList = {}", deleteList);
	}

	@Test
	public void insertErrorBoardMapper() {

		ErrorBoardDTO errorBoardDTO = new ErrorBoardDTO();
		int result = 0;
		for (int i = 0; i < 50; i++) {
			errorBoardDTO.setErrCode("aaaa" + i);
			errorBoardDTO.setTitle("에러코드 테스트" + i);
			errorBoardDTO.setContent("내용은 이렇고" + i);
			errorBoardDTO.setWriter("aaaa1234");
			result += errorBoardMapper.insert(errorBoardDTO);
		}
		for (int i = 0; i < 50; i++) {
			errorBoardDTO.setErrCode("bbbb" + i);
			errorBoardDTO.setTitle("제목에러로만" + i);
			errorBoardDTO.setContent("내용은 이렇고" + i);
			errorBoardDTO.setWriter("aaaa1234");
			result += errorBoardMapper.insert(errorBoardDTO);
		}
		for (int i = 20; i < 30; i++) {
			errorBoardDTO.setErrCode("cccc" + i);
			errorBoardDTO.setTitle("테스트용" + i);
			errorBoardDTO.setContent("내용은 이렇고" + i);
			errorBoardDTO.setWriter("aaaa1234");
			result += errorBoardMapper.insert(errorBoardDTO);
		}
		assertTrue(result == 150);
	}

	@Test
	public void selectUpdateBoardMapper() {
		ErrorBoardDTO errorBoardDTO = new ErrorBoardDTO();
		errorBoardDTO.setErrBno(6);
		errorBoardDTO.setErrCode("11220303");
		errorBoardDTO.setTitle("제목도 변경");
		errorBoardDTO.setContent("에러코드내용변경");
		errorBoardDTO.setWriter("aaaa1234");
		errorBoardDTO.setErrBoardThum(
			"https://test-bucket-myappaws.s3.ap-northeast-2.amazonaws.com/b17500e5-387f-4754-82d8-8b49e9c8dc9a_%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-07-13%20210223.png");

		int result = sqlSession.update(namespace + "modify", errorBoardDTO);

		log.info("result = {}", result);
		assertTrue(result == 1);
	}
}