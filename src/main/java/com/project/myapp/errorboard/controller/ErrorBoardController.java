package com.project.myapp.errorboard.controller;

import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.PageHandler;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.errorboard.service.ErrorBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/errorBoard")
public class ErrorBoardController {

    @Autowired
    ErrorBoardService errorBoardService;

    @GetMapping("/list")
    public String getBoardList(Model m, SearchCondition sc , HttpServletRequest request){

        System.out.println("m = " + m);
        System.out.println("sc = " + sc);
        try {
            int totalCnt = this.errorBoardService.getSearchResultCount(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<ErrorBoardDTO> boardList = this.errorBoardService.getSearchSelectPage(sc);

            m.addAttribute("boardList", boardList);
            m.addAttribute("ph", pageHandler);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg" , "LIST_ERR");
            m.addAttribute("totalCnt" , 0);
        }
        System.out.println("sc = " + sc);
        return "errorBoard/main";
    }
}
