package com.project.myapp.board.controller;

import com.project.myapp.board.service.BoardService;
import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.PageHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

//    @GetMapping("/boardList")
//    public String getBoardList(Model m){
//
//        List<BoardDTO> boardList = boardService.getBoardList();
//        m.addAttribute("boardList", boardList);
//
//        return "board/boardList";
//    }
    @GetMapping("/boardList")
    public List<BoardDTO> getBoardList(Integer page , Integer pageSize, Model m){

        int totalCnt = this.boardService.getBoardCount();

        if(page == null) page = 1;
        if(pageSize == null) pageSize = 10;

        m.addAttribute("totalCnt", totalCnt);
        PageHandler pageHandler = new PageHandler(totalCnt, page , pageSize);
        Map map = new HashMap();
        map.put("offset", (page -1) * pageSize);
        map.put("pageSize", pageSize);

        List<BoardDTO> boardList = this.boardService.getSelectPage(map);

        System.out.println("pageHandler = " + pageHandler);
        m.addAttribute("boardList", boardList);
        m.addAttribute("ph", pageHandler);
        m.addAttribute("page", page);
        m.addAttribute("pageSize", pageSize);

        return boardList;
    }

}
