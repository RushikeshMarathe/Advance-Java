package com.gym.global_exception;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.gym.dto.ApiResponse;

@RestControllerAdvice
public class GlobalException {
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> defaultExceptionHandler(RuntimeException e){
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(new ApiResponse(e.getMessage(), "Failed"));
	}
	
	
	
	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> globalDefaultExceptionHandler(MethodArgumentNotValidException e){
		List<FieldError> errors = e.getFieldErrors();
		return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR)
				.body(errors.stream().collect(Collectors.toMap(FieldError::getField,FieldError::getDefaultMessage)));
	}
}
