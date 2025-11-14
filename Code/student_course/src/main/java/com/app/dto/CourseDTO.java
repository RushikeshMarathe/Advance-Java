package com.app.dto;

import java.time.LocalDate;

import com.app.entities.Category;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
public class CourseDTO {

	@NotBlank(message="Name should not Blank!...")
	private String name;
	private Category category;
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
	private int marks;
	
}
