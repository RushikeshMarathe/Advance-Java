package com.app.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Getter
@Setter
@ToString
public class ApiResponse {
	
	public ApiResponse(String status, String message) {
		super();
		this.status = status;
		this.message = message;
		this.date_time = LocalDateTime.now();
	}

	private String status;
	
	private String message;
	
	private LocalDateTime date_time;
}
