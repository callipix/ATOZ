package com.project.myapp.board.controller;

import com.project.myapp.board.service.CommentService;
import com.project.myapp.dto.CommentDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class CommentController {

    @Autowired
    CommentService commentService;

    @ResponseBody
    @PatchMapping("/comments/{cno}")
    public ResponseEntity<String> modify(@PathVariable Integer cno , @RequestBody CommentDTO commentDTO , HttpSession session){

        System.out.println("commentDTO = " + commentDTO);

        String commenter = (String) session.getAttribute("id");

        commentDTO.setCno(cno);
        commentDTO.setCommenter(commenter);

        try {
            int result = this.commentService.updateComment(commentDTO);
            if(result != 1){
                throw new Exception("modify failed");
            }
            return new ResponseEntity<>("MOD_OK" , HttpStatus.OK);
        } catch (Exception e) {
            e.printStackTrace();
            return new ResponseEntity<>("MOD_ERR" , HttpStatus.BAD_REQUEST);
        }
    }

    // 댓글 등록
    @ResponseBody
    @PostMapping("/comments")
    public ResponseEntity<CommentDTO> write(CommentDTO commentDTO, HttpSession session){

        String commenter = (String)session.getAttribute("id");
        commentDTO.setCommenter(commenter);
        try {
            CommentDTO result = this.commentService.insertComment(commentDTO);
                if(result == null){
                throw new Exception("Write failed");
            }
            System.out.println("Controller commentDTO = " + commentDTO);
            System.out.println("ResponseEntity.ok(commentDTO)= "+ ResponseEntity.ok(commentDTO));
            return ResponseEntity.ok(commentDTO);
//            return new ResponseEntity<>(commentDTO , HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>(commentDTO , HttpStatus.BAD_REQUEST);
        }
    }

    // 지정된 댓글을 삭제하는 메서드
    @DeleteMapping("/comments/{cno}")
    @ResponseBody
    public ResponseEntity<String> remove(@PathVariable Integer cno , Integer bno , HttpSession session) {

        String commenter = (String)session.getAttribute("id");

        try {
            int result = this.commentService.deleteComment(cno , bno , commenter);

            if(result != 1) {
                throw new Exception("Delete failed");
            }
            return new ResponseEntity<>("DEL_OK" , HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            return new ResponseEntity<>("DEL_ERR" , HttpStatus.BAD_REQUEST);
        }
    }
    @GetMapping("/comments")
    @ResponseBody
    public ResponseEntity<List<CommentDTO>> commentList(Integer bno, Model m){
        // 지정된 게시물의 모든 댓글 리스트 가져오기
        List<CommentDTO> list = null;

        try {
            list = this.commentService.getCommentForBoard(bno);
            // 댓글 리스트를 정상적으로 가져왔을시에 http 상태코드를 200으로 설정
            for(CommentDTO commentDTO : list){
                System.out.println("list = " + list);
            }
            m.addAttribute("list", list);
            return new ResponseEntity<List<CommentDTO>>(list , HttpStatus.OK);
        } catch (Exception e){
            e.printStackTrace();
            //  에러 발생시 http의 상태코드를 400으로 변경
            return new ResponseEntity<List<CommentDTO>>(list , HttpStatus.BAD_REQUEST);
        }
    }
}
