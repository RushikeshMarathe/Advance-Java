package com.healthcare.custom_exceptions;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.healthcare.dto.ApiResponse;

import jakarta.validation.ConstraintViolationException;

@RestControllerAdvice
public class GlobalException {

	@ExceptionHandler(MethodArgumentNotValidException.class)
	public ResponseEntity<?> handleMethodArgumentNotValidException(MethodArgumentNotValidException e){
		List<FieldError> list = e.getFieldErrors();
		
		Map<String,String> map = list.stream().collect(Collectors.toMap(FieldError::getField, FieldError::getDefaultMessage));
		
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.healthcare.dto.ApiResponse("Failed",e.getMessage()));
	}
	
	@ExceptionHandler(ConstraintViolationException.class)
	public ResponseEntity<?> handleConstraintViolationException(ConstraintViolationException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new com.healthcare.dto.ApiResponse("Failed", e.getMessage()));
	}
	
	
	@ExceptionHandler(RuntimeException.class)
	public ResponseEntity<?> handleRuntimeException(RuntimeException e)
	{
		return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", e.getMessage()));
	}
}
