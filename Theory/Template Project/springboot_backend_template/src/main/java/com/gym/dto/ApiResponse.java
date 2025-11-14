package com.gym.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class ApiResponse {
	
	
	private String status;
	private String message;
	private LocalDateTime time;
	
	public ApiResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.time = LocalDateTime.now();
	}
}
