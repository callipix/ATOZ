package com.project.atoz.errorboard.controller;

import java.time.Instant;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.project.atoz.dto.ErrorBoardDTO;
import com.project.atoz.dto.FilesDTO;
import com.project.atoz.dto.PageHandler;
import com.project.atoz.dto.SearchCondition;
import com.project.atoz.errorboard.service.ErrorBoardService;
import com.project.atoz.fileupload.AwsS3FileUploadService;
import com.project.atoz.fileupload.mapper.FileMapper;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

@Slf4j
@Controller
@RequestMapping("/errorBoard")
@RequiredArgsConstructor
public class ErrorBoardController {

	private final AwsS3FileUploadService awsS3FileUploadService;
	private final ErrorBoardService errorBoardService;
	private final FileMapper fileMapper;

	@ResponseBody
	@PostMapping("/isCheckWriter")
	public ResponseEntity<String> isCheckWriter(String sessionId, Integer errBno) {
		int result = errorBoardService.isCheckWriter(sessionId, errBno);
		if (result != 1) {
			return new ResponseEntity<>("notEqualsWriter", HttpStatus.OK);
		}
		return new ResponseEntity<>("equalsWriter", HttpStatus.OK);
	}

	@GetMapping("/write")
	public String write(Model model) {
		model.addAttribute("mode", "new");
		log.info("model.getAttribute(\"mode\") = {}", model.getAttribute("mode"));
		return "errorBoard/write";
	}

	@PostMapping("/write")
	public String write(ErrorBoardDTO errorBoardDTO, @RequestParam List<String> afterList, RedirectAttributes ratts,
		Model model, HttpSession session) {

		log.info("errorBoardDTO = {}", errorBoardDTO);
		log.info("afterList = {}", afterList);
		String writer = (String)session.getAttribute("id");
		errorBoardDTO.setWriter(writer);
		int result = 0;
		try {
			result = this.errorBoardService.insertErrorBoardMapper(errorBoardDTO, afterList);

			if (result == 0) {
				model.addAttribute("mode", "new");
				ratts.addFlashAttribute("msg", "WRT_ERR");
				return "/errorBoard/read";
			}
			ratts.addFlashAttribute("msg", "WRT_OK");
			return "redirect:/errorBoard/list";
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/errorBoard/list";
	}

	@GetMapping("/modify")
	public String modify(Integer errBno, Model model) {

		ErrorBoardDTO errorBoardDTO = this.errorBoardService.getErrorBoardByErrBno(errBno);
		model.addAttribute("errorBoardDTO", errorBoardDTO);
		model.addAttribute("mode", "mod");
		return "errorBoard/modify";
	}

	@PostMapping("/modify")
	public String modify(ErrorBoardDTO errorBoardDTO, @RequestParam List<String> afterList, SearchCondition sc,
		RedirectAttributes ratts, Model model, HttpSession session) {
		String writer = (String)session.getAttribute("id");
		errorBoardDTO.setWriter(writer);
		List<FilesDTO> filesDTOList = this.fileMapper.getDeleteList(errorBoardDTO.getErrBno());
		for (FilesDTO filesDTO : filesDTOList) {
			log.info("filesDTO = {}", filesDTO);
		}
		int result = 0;
		try {
			result = this.errorBoardService.update(errorBoardDTO, afterList);
			if (result == 0) {
				throw new Exception("Modify Error");
			}

			ratts.addFlashAttribute("msg", "MOD_OK");
			//            return "redirect:/errorBoard/list" + sc.getQueryString();
			return "redirect:/errorBoard/read?errBno=" + errorBoardDTO.getErrBno();
		} catch (Exception e) {
			e.printStackTrace();
			model.addAttribute(errorBoardDTO);
			ratts.addFlashAttribute("msg", "MOD_ERR");
			return "errorBoard/read";
		}
	}

	@PostMapping("/remove")
	public String remove(Integer errBno, SearchCondition sc, HttpSession session, RedirectAttributes ratts) throws
		Exception {
		String writer = (String)session.getAttribute("id");
		String msg = "DEL_OK";

		int result = 0;

		List<FilesDTO> filesDTOList = this.fileMapper.getDeleteList(errBno);
		try {
			result = this.errorBoardService.delete(errBno, writer);
			if (result == 0) {
				throw new Exception("Delete failed");
			}
			result += this.awsS3FileUploadService.deleteFileAwsS3(filesDTOList);
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

			log.info("컨트롤러 errorBoardDTO = {}", errorBoardDTO);
			model.addAttribute("mode", "mod");
			model.addAttribute(errorBoardDTO);
		} catch (Exception e) {
			e.printStackTrace();
			ratts.addAttribute("msg", "READ_ERR");
			return "redirect:list" + sc.getQueryString();
		}
		return "/errorBoard/read";
	}

	@GetMapping("/list")
	public String getBoardList(Model m, SearchCondition sc, HttpServletRequest request) {

		try {
			int totalCnt = this.errorBoardService.getSearchResultCount(sc);
			m.addAttribute("totalCnt", totalCnt);

			sc.setPageSize(6);
			PageHandler pageHandler = new PageHandler(totalCnt, sc);

			List<ErrorBoardDTO> boardList = this.errorBoardService.getSearchSelectPage(sc);

			m.addAttribute("boardList", boardList);
			m.addAttribute("ph", pageHandler);

			for (ErrorBoardDTO errorBoardDTO : boardList) {
				log.info("errorBoardDTO from getBoardList = {}", errorBoardDTO);
			}
			Instant startOfToday = LocalDate.now().atStartOfDay(ZoneId.systemDefault()).toInstant();
			m.addAttribute("startOfToday", startOfToday.toEpochMilli());
		} catch (Exception e) {
			e.printStackTrace();
			m.addAttribute("msg", "LIST_ERR");
			m.addAttribute("totalCnt", 0);
		}
		log.info("sc = {}", sc);
		return "errorBoard/list";
	}
}
