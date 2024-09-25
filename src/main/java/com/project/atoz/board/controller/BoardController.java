package com.project.atoz.board.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.atoz.board.service.BoardService;
import com.project.atoz.board.service.CommentService;
import com.project.atoz.dto.BoardDTO;
import com.project.atoz.dto.CommentDTO;
import com.project.atoz.dto.PageHandler;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.security.auth.CustomDetails;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/board")
@RequiredArgsConstructor
public class BoardController {

	private final BoardService boardService;
	private final CommentService commentService;

	@GetMapping("/modify")
	public String modify(Integer bno, Model m) {

		BoardDTO boardDTO = this.boardService.getBoardByBno(bno);
		m.addAttribute("boardDTO", boardDTO);
		m.addAttribute("mode", "mod");
		return "/board/modify";
	}

	/**
	 * 게시글 삭제 메서드
	 *
	 * @param bno     게시글 번호
	 * @param sc      삭제 후에도 기존 페이지로 돌아가기 위해 사용
	 * @param session 작성자 아이디를 가져오기 위한 세션 → 시큐리티 세션으로 변경
	 * @param rattr   리다이렉트 하기 위한 변수
	 * @return
	 */
	@ResponseBody
	@PostMapping("/remove")
	public String remove(@RequestBody Map<String, Object> removeData, RedirectAttributes rattr) {

		Integer bno = Integer.parseInt((String)removeData.get("bno"));

		ObjectMapper mapper = new ObjectMapper();
		SearchCondition sc = mapper.convertValue(removeData.get("sc"), SearchCondition.class);

		log.info("sc = {}", sc);
		log.info("bno = {}", bno);

		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();
		String writer = userDetails.getUser().getId();

		log.info("writer from remove = {}", writer);
		log.info("bno from remove = {}", bno);

		String msg = "DEL_OK";
		try {
			int result = this.boardService.deleteByIdNBno(bno, writer);
			if (result != 1) {
				throw new Exception("Delete failed");
			}
		} catch (Exception e) {
			e.printStackTrace();
			msg = "DEL_ERR";
		}
		rattr.addFlashAttribute("msg", msg);
		return "/board/boardList" + sc.getQueryString();
	}

	// 글수정
	@PostMapping("/modify")
	public String modify(BoardDTO boardDTO, SearchCondition sc, RedirectAttributes rattr, Model m) throws Exception {
		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		String writer = userDetails.getName();
		boardDTO.setWriter(writer);

		int result = this.boardService.updateBoardByIdNBno(boardDTO);
		try {
			if (result != 1) {
				throw new Exception("Modify Error");
			}
			rattr.addFlashAttribute("msg", "MOD_OK");
			return "/board/boardList" + sc.getQueryString();
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute(boardDTO);
			rattr.addAttribute("msg", "MOD_ERR");
			return "/board/board";
		}
	}

	@GetMapping("/write")
	public String write(Model m) {
		m.addAttribute("mode", "new");
		return "/board/write";
	}

	@ResponseBody
	@PostMapping("/write")
	public ResponseEntity<Map<String, String>> write(BoardDTO boardDTO, RedirectAttributes rattr, Model m)
		throws Exception {

		log.info("boardDTO for write from BoardController = {}", boardDTO);

		CustomDetails userDetails = (CustomDetails)SecurityContextHolder.getContext()
			.getAuthentication()
			.getPrincipal();

		log.info("userDetails.getUser().getId() = {}", userDetails.getUser().getId());

		String writer = userDetails.getName();
		log.info("writer = {}", writer);

		//		String writer = (String)session.getAttribute("id");
		boardDTO.setWriter(writer);

		int result = this.boardService.insertBoard(boardDTO);

		Map<String, String> responseMap = new HashMap<>();
		if (result != 1) {
			m.addAttribute("mode", "new");
			// rattr.addAttribute("msg", "WRT_ERR");
			responseMap.put("msg", "WRT_ERR");
			responseMap.put("redirectURL", "/board/board");
			return ResponseEntity.badRequest().body(responseMap);
		} else {
			// rattr.addFlashAttribute("msg", "WRT_OK");
			responseMap.put("msg", "WRT_OK");
			responseMap.put("redirectURL", "/board/boardList");
			return ResponseEntity.ok(responseMap);  // JSON으로 응답
		}
	}

	@GetMapping("/read")
	public String read(Integer bno, SearchCondition sc, RedirectAttributes rattr, Model m) {

		try {
			BoardDTO boardDTO = this.boardService.getBoardByBno(bno);
			List<CommentDTO> commentList = this.commentService.getCommentForBoard(bno);

			m.addAttribute("commentList", commentList);
			m.addAttribute("mode", "mod");
			m.addAttribute(boardDTO);
		} catch (Exception e) {
			e.printStackTrace();
			rattr.addAttribute("msg", "READ_ERR");
			return "redirect:boardList" + sc.getQueryString();
		}
		return "/board/board";
	}

	@GetMapping("/boardList")
	public String getBoardList(Model m, SearchCondition sc) {
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
			m.addAttribute("msg", "LIST_ERR");
			m.addAttribute("totalCnt", 0);
		}
		return "/board/boardList";
	}
}