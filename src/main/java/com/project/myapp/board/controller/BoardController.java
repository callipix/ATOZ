package com.project.myapp.board.controller;

import com.project.myapp.board.service.BoardService;
import com.project.myapp.board.service.CommentService;
import com.project.myapp.dto.BoardDTO;
import com.project.myapp.dto.CommentDTO;
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

    BoardService boardService;
    CommentService commentService;

    @Autowired          // 생성자주입
    BoardController (BoardService boardService, CommentService commentService){
        this.boardService = boardService;
        this.commentService = commentService;
    }

    @GetMapping("/write")
    public String write(Model m){
        m.addAttribute("mode","new");
        return "board/board";
    }
    // 글삭제
    @PostMapping("/remove")
    public String remove(Integer bno, SearchCondition sc, HttpSession session, RedirectAttributes rattr){
        String writer = (String)session.getAttribute("id");
        String msg = "DEL_OK";
        try {
            int result = this.boardService.deleteByIdNBno(bno , writer);
            System.out.println("result = " + result);
                if(result != 1){
                    throw new Exception("Delete failed"); 
                }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";
        }
        rattr.addFlashAttribute("msg",msg);
        System.out.println("msg = " + msg);
        return "redirect:/board/boardList"+ sc.getQueryString();
    }

    // 글수정
    @PostMapping("/modify")
    public String modify(BoardDTO boardDTO, SearchCondition sc, RedirectAttributes rattr, Model m , HttpSession session) throws Exception {

        String writer = (String)session.getAttribute("id");
        boardDTO.setWriter(writer);
        int result = this.boardService.updateBoardByIdNBno(boardDTO);
        try {
            if(result != 1){
                throw new Exception("Modify Error");
            }
            rattr.addFlashAttribute("msg","MOD_OK");
            return "redirect:/board/boardList"+sc.getQueryString();
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute(boardDTO);
            m.addAttribute("msg","MOD_ERR");
            return "board/board";
        }
    }
    @PostMapping("/write")
    public String write(BoardDTO boardDTO, RedirectAttributes rattr, Model m, HttpSession session) throws Exception {

        System.out.println("boardDTO = " + boardDTO);
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
    public String read(Integer bno, SearchCondition sc, RedirectAttributes rattr, Model m){
        try {
            BoardDTO boardDTO = this.boardService.getBoardByBno(bno);
            List<CommentDTO> commentList = this.commentService.getCommentForBoard(bno);

            m.addAttribute("commentList",commentList);
            m.addAttribute("mode","mod");
            m.addAttribute(boardDTO);
            System.out.println("boardDTO = " + boardDTO);
            System.out.println("commentList = " + commentList);
        } catch (Exception e){
            e.printStackTrace();
            rattr.addAttribute("msg" , "READ_ERR");
            return "redirect:boardList"+sc.getQueryString();
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
        return "board/boardList";
    }
}