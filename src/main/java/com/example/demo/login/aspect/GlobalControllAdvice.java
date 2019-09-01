package com.example.demo.login.aspect;

import org.springframework.dao.DataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Component;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
@Component
public class GlobalControllAdvice {

	@ExceptionHandler(DataAccessException.class)
	public String dataAccessExceptionHandler(DataAccessException e, Model model) {
		model.addAttribute("error", "内部サーバーエラー、GlobalControllerAdvice");
		model.addAttribute("message", "DataAccessExceptionが発生");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}

	@ExceptionHandler(Exception.class)
	public String exceptionHandler(DataAccessException e, Model model) {
		model.addAttribute("error", "内部サーバーエラー、GlobalControllerAdvice");
		model.addAttribute("message", "Exceptionが発生");
		model.addAttribute("status", HttpStatus.INTERNAL_SERVER_ERROR);
		return "error";
	}

}
