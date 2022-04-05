package com.barclays.student.demo.exception;

import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

@ControllerAdvice
public class DemoAppExceptionHandler extends ResponseEntityExceptionHandler {

	@Override
	protected ResponseEntity<Object> handleMethodArgumentNotValid(MethodArgumentNotValidException ex,
			HttpHeaders headers, HttpStatus status, WebRequest request) {
		
		List<ObjectError> errors = ex.getAllErrors();
		Map<String, String> map = new LinkedHashMap<String, String>();
		
		for(ObjectError error : errors) {
			String message = error.getDefaultMessage();
			FieldError fieldError = (FieldError) error;
			String fieldName = fieldError.getField();
			map.put(fieldName, message);
		}
		return new ResponseEntity<Object>(map,HttpStatus.BAD_REQUEST);
	}
	
	
}
