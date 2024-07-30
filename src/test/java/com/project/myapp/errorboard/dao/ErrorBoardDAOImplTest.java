package com.project.myapp.errorboard.dao;

import com.project.myapp.dto.ErrorBoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.*;
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"file:src/main/webapp/WEB-INF/spring/root-context.xml"})
public class ErrorBoardDAOImplTest {

    @Autowired
    private ErrorBoardDAO errorBoardDAO;

    private static final String namespace = "com.project.myapp.errorboard.dao.ErrorBoardMapper.";

    @Autowired
    private SqlSession sqlSession;

    @Test
    public void insertErrorBoardMapper() {

        ErrorBoardDTO errorBoardDTO = new ErrorBoardDTO();

        errorBoardDTO.setErrCode("11220303");
        errorBoardDTO.setTitle("에러코드 테스트");
        errorBoardDTO.setContent("내용은 이렇고");
        errorBoardDTO.setWriter("aaaa1234");

//        errorBoardDTO.setErrBoardThum("https://test-bucket-myappaws.s3.ap-northeast-2.amazonaws.com/b17500e5-387f-4754-82d8-8b49e9c8dc9a_%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-07-13%20210223.png");

        int result = errorBoardDAO.insertErrorBoardMapper(errorBoardDTO);
        assertTrue(result == 1);
    }

    @Test
    public void selectUpdateBoardMapper() {
        ErrorBoardDTO errorBoardDTO = new ErrorBoardDTO();
        errorBoardDTO.setErrBno(6);
        errorBoardDTO.setErrCode("11220303");
        errorBoardDTO.setTitle("제목도 변경");
        errorBoardDTO.setContent("에러코드내용변경");
        errorBoardDTO.setWriter("aaaa1234");
        errorBoardDTO.setErrBoardThum("https://test-bucket-myappaws.s3.ap-northeast-2.amazonaws.com/b17500e5-387f-4754-82d8-8b49e9c8dc9a_%EC%8A%A4%ED%81%AC%EB%A6%B0%EC%83%B7%202024-07-13%20210223.png");

        int result = sqlSession.update(namespace + "modify", errorBoardDTO);

        System.out.println("result = " + result);
        assertTrue(result == 1);
    }
}