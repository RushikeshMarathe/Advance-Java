package com.healthcare.dto;

import java.time.LocalDateTime;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class NewAppointment {
	/*
	 * "patientId": 3,
  "doctorId": 5,
  "appointmentDateTime": "2025-11-05T10:30:00",

	 */
	private Long patientId;
	private Long doctorId;
	private LocalDateTime appointmentDateTime;

}
