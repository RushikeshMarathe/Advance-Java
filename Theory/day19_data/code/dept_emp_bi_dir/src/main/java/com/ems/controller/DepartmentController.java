package com.ems.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.ems.service.DepartmentService;

import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.AllArgsConstructor;


@RestController
@RequestMapping("/departments")
@AllArgsConstructor
public class DepartmentController {
	//depcy - service layer i/f	
	private final DepartmentService departmentService;
	
	/*
	 * Desc - Get Department & emp details 
	 * URL - http://host:port/departments/{deptId}/employees
	 * Method - GET
	 * Path var - dept id
	 * Resp - Dept DTO HAS-A  with Emp DTOs
	 */
	@GetMapping("/{deptId}/employees")
	@ApiResponse(description ="Get Department & emp details" )
	public ResponseEntity<?> getDepartmentWithEmps(@PathVariable Long deptId) {
		System.out.println("in get dept + emps "+deptId);
		System.out.println("Service - "+departmentService.getClass());
		return ResponseEntity.ok(departmentService.getDepartmentAndEmps(deptId));
	}
	
	
	
	

}
