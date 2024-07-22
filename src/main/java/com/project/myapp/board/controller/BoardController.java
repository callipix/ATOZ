package com.project.myapp.board.controller;

import com.project.myapp.board.service.BoardService;
import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.PageHandler;
import com.project.myapp.dto.SearchCondition;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/board")
public class BoardController {

    @Autowired
    BoardService boardService;

    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("mode","new");
        return "board/board";
    }

    @PostMapping("/write")
    public String write(BoardDTO boardDTO, RedirectAttributes rattr, Model m, HttpSession session) throws Exception {

        String writer = (String) session.getAttribute("id");
        boardDTO.setWriter(writer);

        int result = this.boardService.insertBoard(boardDTO);

        if(result != 1) {
            m.addAttribute("mode","new");
            m.addAttribute("msg","WRT_ERR");
            System.out.println("result = " + result);
            return "/board/board";
        } else {
            rattr.addFlashAttribute("msg","WRT_OK");
            return "redirect:/board/boardList";
        }
    }
    @GetMapping("/read")
    public String read(Integer bno ,RedirectAttributes rattr, Model m){
        try {
            BoardDTO boardDTO = this.boardService.getBoardByBno(bno);
            m.addAttribute(boardDTO);
        } catch (Exception e){
            e.printStackTrace();
            rattr.addAttribute("msg" , "READ_ERR");
            return "redirect:boardList?bno="+bno;
        }
        return "/board/board";
    }
    @GetMapping("/boardList")
    public String getBoardList(Model m, SearchCondition sc , HttpServletRequest request){

        try {
            int totalCnt = this.boardService.getSearchResultCount(sc);
            m.addAttribute("totalCnt", totalCnt);

            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<BoardDTO> boardList = this.boardService.getSearchSelectPage(sc);

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
        System.out.println("sc.getPage() = " + sc.getPage());
        return "board/boardList";
    }
}