package com.gym.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.gym.dto.ApiResponse;
import com.gym.dto.TrainerDTO;
import com.gym.service.TrainerService;

import jakarta.validation.Valid;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/trainer")
@AllArgsConstructor
public class TrainerController {

	private final TrainerService trainerService;
	
	@PostMapping("/add")
	public ResponseEntity<?> addNewTrainer(@RequestBody @Valid TrainerDTO trainer)
	{
		
		
//		try {
			
			return ResponseEntity.status(HttpStatus.CREATED).body(trainerService.createNewTrainer(trainer));
			
//		}catch(RuntimeException e)
//		{
//			return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(new ApiResponse("Failed", e.getMessage()));
//		}
	}
}
