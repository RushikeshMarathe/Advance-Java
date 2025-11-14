package com.app.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app.custom_cexception.StudentCourseException;
import com.app.dto.CourseDTO;
import com.app.dto.UpdateCourseDTO;
import com.app.service.CourseService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/course")
public class CourseController {

	private CourseService courseService;

	@PostMapping("/add")
	public ResponseEntity<?> addNewCourse(@RequestBody @Valid CourseDTO newCourseToAdd) {
//		try {
			if (newCourseToAdd.getStartDate().isBefore(newCourseToAdd.getEndDate())) {
				return ResponseEntity.ok(courseService.createNewCourse(newCourseToAdd));
			} else {
				throw new StudentCourseException("Start date is not valid must before end date");
			}
//		} catch (RuntimeException e) {
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", e.getMessage()));
//		}
	}
	
	
	@PutMapping("/update/{id}")
	public ResponseEntity<?> updateCourse(@PathVariable @Validated Long id,@RequestBody @Valid UpdateCourseDTO newDetails)
	{
//		try {
			
			return ResponseEntity.ok(courseService.modifyCourse(id,newDetails));
			
//		}catch(RuntimeException e)
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed",e.getMessage()));
//		}
	}
	
	
	@GetMapping("/allCourses/{name}")
	public ResponseEntity<?> getAllCourses(@PathVariable @Validated String name)
	{
//		try {
			return ResponseEntity.ok(courseService.getAllCourse(name));
//		}catch(RuntimeException e)
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", e.getMessage()));
//		}
		
	}

}
