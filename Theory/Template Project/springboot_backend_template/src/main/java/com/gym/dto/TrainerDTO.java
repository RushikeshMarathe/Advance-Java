package com.gym.dto;

import com.gym.entities.Specialization;

import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Positive;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class TrainerDTO {
	@NotBlank(message="name should not empty!...")
	private String name;
	private Specialization specialization;
//	@Min(value=0, message = "Experience should be positive!..")
	@Positive(message = "Experience should be positive")
	
	private Long experienceYears;
	@NotBlank(message = "contact should not empty")
	private String contactNumber;
}
