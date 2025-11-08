package com.ems.dto;

import java.time.LocalDate;

import com.ems.entities.EmploymentType;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class EmployeeDTO {
	private String firstName;
	private String lastName;	
	private LocalDate joinDate;
	private EmploymentType type;
	private double salary;

}
