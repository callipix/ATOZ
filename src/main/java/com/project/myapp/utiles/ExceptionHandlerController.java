package com.project.myapp.utiles;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ExceptionHandlerController {

	public static final Logger logger = LoggerFactory.getLogger(ExceptionHandlerController.class);

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(Exception e, Model model) {
		logger.info("404 에러페이지 입장!{}");
		logger.error(e.getMessage());
		model.addAttribute("exception", e);

		return "errorPage/error404";
	}

}
