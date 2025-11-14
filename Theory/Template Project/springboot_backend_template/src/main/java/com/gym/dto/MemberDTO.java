package com.gym.dto;

import java.time.LocalDate;

import com.gym.entities.MemberType;
import com.gym.entities.Trainer;

import jakarta.persistence.Column;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Past;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MemberDTO {
	@NotBlank(message = "Name should not be blank")
	private String name;
	@Email(message = "Invalid email format")
	private String email;
	
	private int weight;
	
	private Long height;
	private MemberType memberType;
	@Past
	private LocalDate joinDate;

	private Long trainer;
}
