package com.gym.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.dto.ApiResponse;
import com.gym.dto.PolicyDto;
import com.gym.service.PolicyService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/policy")
@AllArgsConstructor
public class PolicyController {
	private final PolicyService policyService;	
	
	@PostMapping("/add")
	public ResponseEntity<?> addPolicy(@Valid @RequestBody PolicyDto policydto){
		try {
			return ResponseEntity.ok(policyService.addPolicy(policydto));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage(), "Failed!"));
		}
	}
	
	@PutMapping("/update-GreaterThan")
	public ResponseEntity<?> updatefindByCamountGreaterThan(){
		try {
			return ResponseEntity.ok(policyService.findByCamountGreaterThan(100));
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage(), "Failed!"));
		}
	}
	
	
	@GetMapping("/all")
	public ResponseEntity<?> getAll(){
		try {
			return ResponseEntity.ok(policyService.getAll());
		}catch(RuntimeException e) {
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse(e.getMessage(), "Failed!"));
		}
	}
}
