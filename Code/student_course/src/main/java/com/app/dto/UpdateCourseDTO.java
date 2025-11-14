package com.app.dto;

import java.time.LocalDate;

import jakarta.validation.constraints.Min;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class UpdateCourseDTO {
	private LocalDate startDate;
	private LocalDate endDate;
	private double fees;
}
