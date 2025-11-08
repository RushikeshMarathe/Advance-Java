package com.healthcare.dto;

import jakarta.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class PasswordUpdateDTO {
	@NotBlank(message = "Password must not be blank")
	private String newPassword;
}
