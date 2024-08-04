package com.project.myapp.suggestion.controller;

import com.project.myapp.dto.PageHandler;
import com.project.myapp.dto.SuggestionDTO;
import com.project.myapp.suggestion.service.SuggestionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

@Slf4j
//@RestController
@Controller
public class SuggestionController {

    SuggestionService suggestionService;

    @Autowired
    public SuggestionController(SuggestionService suggestionService) {
        this.suggestionService = suggestionService;
    }

    @PostMapping("/suggestions")
    @ResponseBody
    public ResponseEntity<SuggestionDTO> write(SuggestionDTO suggestionDTO){
        System.out.println("suggestionDTO = " + suggestionDTO);
        try{
            suggestionDTO = this.suggestionService.insert(suggestionDTO);
            if(suggestionDTO == null){
                throw new Exception("Write failed");
            }
            log.info("suggestionDTO result {}" , suggestionDTO);
            return ResponseEntity.ok(suggestionDTO);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(suggestionDTO, HttpStatus.BAD_REQUEST);
        }
    }

    @PatchMapping("/suggestions/{sno}")
    @ResponseBody
    public ResponseEntity<String> modify(@PathVariable Integer sno, @RequestBody SuggestionDTO suggestionDTO){

        suggestionDTO.setSno(sno);
        try {
            int result = this.suggestionService.update(suggestionDTO);
            if(result != 1){
                throw new Exception("modify failed");
            }
            return new ResponseEntity<>("MOD_OK" , HttpStatus.OK);

        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("MOD_ERR", HttpStatus.BAD_REQUEST);
        }

    }

    @DeleteMapping("/suggestions/{sno}")
    @ResponseBody
    public ResponseEntity<String> delete(@PathVariable Integer sno,String password){
        System.out.println("sno = " + sno);
        System.out.println("password = " + password);
        try {

            int result = this.suggestionService.passCheck(sno , password);
            System.out.println("passCheck result = " + result);
            if(result != 1){
                return new ResponseEntity<>("passNotEqual" , HttpStatus.OK);
            }
            result = this.suggestionService.delete(password,sno);

            if(result != 1){
                throw new Exception("Delete failed");
            }
            return new ResponseEntity<>("DEL_OK" , HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
        }

    }
    @GetMapping("/suggestions")
    public String getSuggestList(Model model){
        try {
            List<SuggestionDTO> suggestionList = this.suggestionService.getSuggestList();
            int suggestCount = this.suggestionService.getSuggestListCount();
            model.addAttribute("suggestionList" ,suggestionList);
            model.addAttribute("suggestCount" , suggestCount);

            for(SuggestionDTO suggest : suggestionList){
                System.out.println("suggest = " + suggest);
            }
            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            model.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg" , "LIST_ERR");
        }
        return "/etc/suggestions";
    }
}
