package com.app.controller;

import org.modelmapper.ModelMapper;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.dto.ApiResponse;
import com.app.dto.StudentDTO;
import com.app.service.StudentService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/student")
@AllArgsConstructor
public class StudentController {
	private final StudentService studentService;
	private ModelMapper modelMapper;
	
	@PostMapping("/add/{id}")
	public ResponseEntity<?> addNewStudent(@PathVariable @Validated Long id, @RequestBody @Valid StudentDTO newStudentToAdd)
	{
		try {
			
		return ResponseEntity.ok(studentService.createNewStudent(id,newStudentToAdd));
			
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", e.getMessage()));
		}
	}
	
}
