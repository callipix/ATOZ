package com.project.myapp.errorboard.controller;

import com.project.myapp.dto.ErrorBoardDTO;
import com.project.myapp.dto.PageHandler;
import com.project.myapp.dto.SearchCondition;
import com.project.myapp.errorboard.service.ErrorBoardService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Controller
@RequestMapping("/errorBoard")
public class ErrorBoardController {

    @Autowired
    ErrorBoardService errorBoardService;
    @GetMapping("/write")
    public String write(Model model) {
        model.addAttribute("mode" , "new");
        System.out.println("model.getAttribute(\"mode\") = " + model.getAttribute("mode"));
        return "errorBoard/write";
    }

    @PostMapping("/write")
    public String write(ErrorBoardDTO errorBoardDTO , RedirectAttributes ratts, Model model, HttpSession session){

        System.out.println("errorBoardDTO = " + errorBoardDTO);
        String writer = (String)session.getAttribute("id");
        errorBoardDTO.setWriter(writer);
        int result = 0;
        try {
            result = this.errorBoardService.insertErrorBoardMapper(errorBoardDTO);

            if(result != 1){
                model.addAttribute("mode" , "new");
                ratts.addFlashAttribute("msg", "WRT_ERR");
                return "/errorBoard/read";
            }
            ratts.addFlashAttribute("msg", "WRT_OK");
            return "redirect:/errorBoard/list";
        } catch (Exception e){
            e.printStackTrace();
        }
        return "redirect:/errorBoard/list";
    }
    @GetMapping("/modify")
    public String modify(Integer errBno, Model model) {

        ErrorBoardDTO errorBoardDTO = this.errorBoardService.getErrorBoardByErrBno(errBno);
        model.addAttribute("errorBoardDTO", errorBoardDTO);
        model.addAttribute("mode" , "mod");
        return "errorBoard/modify";
    }
    @PostMapping("/modify")
    public  String modify(ErrorBoardDTO errorBoardDTO ,SearchCondition sc, RedirectAttributes ratts, Model model, HttpSession session){
        System.out.println("errorBoardDTO = " + errorBoardDTO);
        String writer = (String)session.getAttribute("id");
        errorBoardDTO.setWriter(writer);
        int result = 0;
        try {
            result = this.errorBoardService.update(errorBoardDTO);
            if(result != 1){
                throw new Exception("Modify Error");
            }
            ratts.addFlashAttribute("msg", "MOD_OK");
            return "redirect:/errorBoard/list" + sc.getQueryString();
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute(errorBoardDTO);
            ratts.addFlashAttribute("msg", "MOD_ERR");
            return "errorBoard/read";
        }
    }

    @PostMapping("/remove")
    public String remove(Integer errBno,SearchCondition sc , HttpSession session, RedirectAttributes ratts) {
        String writer = (String)session.getAttribute("id");
        System.out.println("writer = " + writer);
        System.out.println("errBno = " + errBno);
        System.out.println("sc = " + sc);
        String msg = "DEL_OK";
        int result = 0;
        try {
            result = this.errorBoardService.delete(errBno , writer);
            if(result == 0){
                throw new Exception("Delete failed");
            }
        } catch (Exception e) {
            e.printStackTrace();
            msg = "DEL_ERR";
        }
        ratts.addFlashAttribute("msg", msg);
        return "redirect:/errorBoard/list" + sc.getQueryString();
    }

    @GetMapping("/read")
    public String read(Integer errBno, SearchCondition sc, RedirectAttributes ratts, Model model) {

        try {
            ErrorBoardDTO errorBoardDTO = this.errorBoardService.getErrorBoardByErrBno(errBno);

            System.out.println("컨트롤러 errorBoardDTO = " + errorBoardDTO);
            model.addAttribute("mode" , "mod");
            model.addAttribute(errorBoardDTO);
        } catch (Exception e){
            e.printStackTrace();
            ratts.addAttribute("msg" , "READ_ERR");
            return "redirect:list" + sc.getQueryString();
        }
        return "/errorBoard/read";
    }

    @GetMapping("/list")
    public String getBoardList(Model m, SearchCondition sc , HttpServletRequest request){

        try {
            int totalCnt = this.errorBoardService.getSearchResultCount(sc);
            m.addAttribute("totalCnt", totalCnt);

            sc.setPageSize(6);
            PageHandler pageHandler = new PageHandler(totalCnt, sc);

            List<ErrorBoardDTO> boardList = this.errorBoardService.getSearchSelectPage(sc);

            m.addAttribute("boardList", boardList);
            m.addAttribute("ph", pageHandler);

            for(ErrorBoardDTO errorBoardDTO : boardList){
                System.out.println("errorBoardDTO = " + errorBoardDTO);
            }
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            m.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e) {
            e.printStackTrace();
            m.addAttribute("msg" , "LIST_ERR");
            m.addAttribute("totalCnt" , 0);
        }
        System.out.println("sc = " + sc);
        return "errorBoard/list";
    }
}
