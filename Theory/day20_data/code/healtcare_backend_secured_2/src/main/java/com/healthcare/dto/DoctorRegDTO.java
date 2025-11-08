package com.healthcare.dto;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
@Getter
@Setter
@ToString
public class DoctorRegDTO {
	private UserReqDTO userDetails;
	private String speciality;
	private int experienceInYears;
	private String qualifications;
	private int fees;
	
}
