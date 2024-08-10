package com.project.myapp.suggestion.controller;

import com.project.myapp.dto.PageHandler2;
import com.project.myapp.dto.SuggestionDTO;
import com.project.myapp.suggestion.service.SuggestionService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
//@RestController
@Controller
@AllArgsConstructor
public class SuggestionController {

    private final SuggestionService suggestionService;

    @PostMapping("/suggestions")
    @ResponseBody
    public ResponseEntity<SuggestionDTO> write(SuggestionDTO suggestionDTO){
        try{
            suggestionDTO = this.suggestionService.insert(suggestionDTO);
            if(suggestionDTO == null){
                throw new Exception("Write failed");
            }
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
        try {

            int result = this.suggestionService.passCheck(sno , password);
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
    public String getSuggestList(Integer page , Integer pageSize,Model model){

        if(page == null){ page = 1;}
        if(pageSize == null){ pageSize = 4;}

        try {
            int suggestCount = this.suggestionService.getSuggestListCount();
            PageHandler2 pageHandler = new PageHandler2(suggestCount, page , pageSize);

            Map map = new HashMap();
            map.put("offset" , (page-1) * pageSize);
            map.put("pageSize" , pageSize);

            List<SuggestionDTO> suggestionList = this.suggestionService.getSuggestList(map);

            model.addAttribute("suggestionList" , suggestionList);
            model.addAttribute("suggestCount" , suggestCount);
            model.addAttribute("ph" ,pageHandler);
            model.addAttribute("page" , page);
            model.addAttribute("pageSize" , pageSize);

            Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
            model.addAttribute("startOfToday", startOfToday.toEpochMilli());
        } catch (Exception e){
            e.printStackTrace();
            model.addAttribute("msg" , "LIST_ERR");
        }
        return "/etc/suggestions";
    }
}