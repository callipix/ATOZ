package com.project.atoz.board.controller;

import java.util.List;

import com.project.atoz.security.auth.CustomDetails;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.project.atoz.board.service.CommentService;
import com.project.atoz.dto.CommentDTO;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@RestController
@RequiredArgsConstructor
public class CommentController {

	private final CommentService commentService;

	@ResponseBody
	@PatchMapping("/comments/{cno}")
	public ResponseEntity<String> modify(@PathVariable Integer cno, @RequestBody CommentDTO commentDTO) {

		log.info("commentDTO = {}", commentDTO);
		SecurityContextHolder.getContext().getAuthentication().getName();
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();

		String commenter = userDetails.getName();

		commentDTO.setCno(cno);
		commentDTO.setCommenter(commenter);

		try {
			int result = this.commentService.updateComment(commentDTO);
			if (result != 1) {
				throw new Exception("modify failed");
			}
			return new ResponseEntity<>("MOD_OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("MOD_ERR", HttpStatus.BAD_REQUEST);
		}
	}

	/**
	 * 댓글 등록 메서드
	 * @param commentDTO 댓글
	 * @param session 댓글 작성자 아이디를 가져오기 위한 세션 → 시큐리티 세션(JWT)으로 변경
	 * @return 작성된 댓글 DTO 반환
	 */
	@ResponseBody
	@PostMapping("/comments")
	public ResponseEntity<CommentDTO> write(CommentDTO commentDTO) {

		SecurityContextHolder.getContext().getAuthentication().getName();
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();

		String commenter = userDetails.getName();
		commentDTO.setCommenter(commenter);
		try {
			CommentDTO result = this.commentService.insertComment(commentDTO);
			if (result == null) {
				throw new Exception("Write failed");
			}
			return ResponseEntity.ok(commentDTO);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>(commentDTO, HttpStatus.BAD_REQUEST);
		}
	}

	// 지정된 댓글을 삭제하는 메서드
	@ResponseBody
	@DeleteMapping("/comments/{cno}")
	public ResponseEntity<String> remove(@PathVariable Integer cno, Integer bno) {

		SecurityContextHolder.getContext().getAuthentication().getName();
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
				.getAuthentication()
				.getPrincipal();

		String commenter = userDetails.getName();
		try {
			int result = this.commentService.deleteComment(cno, bno, commenter);

			if (result != 1) {
				throw new Exception("Delete failed");
			}
			return new ResponseEntity<>("DEL_OK", HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			return new ResponseEntity<>("DEL_ERR", HttpStatus.BAD_REQUEST);
		}
	}

	@ResponseBody
	@GetMapping("/comments")
	public ResponseEntity<List<CommentDTO>> commentList(Integer bno, Model m) {
		// 지정된 게시물의 모든 댓글 리스트 가져오기
		List<CommentDTO> list = null;
		try {
			list = this.commentService.getCommentForBoard(bno);
			// 댓글리스트 정상적으로 로드 : http 상태코드 200으로 설정
			m.addAttribute("list", list);
			return new ResponseEntity<List<CommentDTO>>(list, HttpStatus.OK);
		} catch (Exception e) {
			e.printStackTrace();
			//  에러 발생시 http 상태코드 400으로 변경
			return new ResponseEntity<List<CommentDTO>>(list, HttpStatus.BAD_REQUEST);
		}
	}
}