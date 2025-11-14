package com.app.dto;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class StudentDTO {
	@NotBlank(message="name should not empty")
	private String name;
	@NotBlank(message="Email should not empty")
	private String email;
	@NotBlank(message="Marks should not empty")
	private int marks;
	
}
