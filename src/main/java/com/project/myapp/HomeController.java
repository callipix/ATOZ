package com.project.myapp;

import com.project.myapp.dto.BoardDTO;
import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import java.util.List;

@Controller
public class HomeController {

    @Autowired
    SqlSession sqlSession;
    @Autowired
    private static final String NAMESPACE = "com.project.myapp.TestMapper.";

    @GetMapping("/")
    public String home() {
        List<BoardDTO> result = test();
        for (BoardDTO dto : result) {
            System.out.println("dto = " + dto);
        }
        return "home";
    }
    public List<BoardDTO> test(){
      List<BoardDTO> list = sqlSession.selectList(NAMESPACE+"test");

      return list;
    }
}
