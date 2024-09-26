package com.project.atoz.utiles;

import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import lombok.extern.slf4j.Slf4j;

@Slf4j
@ControllerAdvice
public class ExceptionHandlerController {

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		log.info("404 에러 페이지 입장!{}");
		log.error(e.getMessage());
		model.addAttribute("exception", e);

		return "errorPage/error404";
	}

}
