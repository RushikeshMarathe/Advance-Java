package com.gym.dto;

import java.time.LocalDate;

import com.gym.entity.PolicyType;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.PastOrPresent;
import jakarta.validation.constraints.Positive;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PolicyDto {
	@NotBlank(message="Name Cannot be Blank")
	private String name;
	@Positive(message="Cammount Cannot be -Ve")
	private int camount;
	@Positive(message="Pammount Cannot be -Ve")
	private int pamount;
	@PastOrPresent(message="Start Date Invalid!")
	private LocalDate startdate;
	private LocalDate enddate;
	@NotNull(message="PolicyType Cannot Be Null")
	private PolicyType ptype;
}
