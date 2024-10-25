package com.example.demo;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;

@ControllerAdvice
public class ExceptionHandler {
    @org.springframework.web.bind.annotation.ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<Map<String,String>> exceptionHandling(MethodArgumentNotValidException ex){
		Map<String,String> error = new HashMap<>();
		ex.getBindingResult().getFieldErrors().forEach(err ->error.put(err.getField(),err.getDefaultMessage()));
		return new ResponseEntity<>(error,HttpStatus.BAD_REQUEST);
	}
	
}
