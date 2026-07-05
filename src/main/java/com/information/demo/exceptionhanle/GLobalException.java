package com.information.demo.exceptionhanle;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

@ControllerAdvice
public class GLobalException {
	@ExceptionHandler(StudentNotFoundException.class)
	@ResponseBody
	public ResponseEntity<String> handlerException(StudentNotFoundException ex) {
		return new ResponseEntity<>(
				ex.getMessage(),
				HttpStatus.NOT_FOUND
				);
	}
	
}
