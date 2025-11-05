package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.ApiResponse;
import com.healthcare.dto.BookedAppointment;
import com.healthcare.dto.NewAppointment;
import com.healthcare.entities.Appointment;
import com.healthcare.service.AppointmentService;

import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/patients")
@AllArgsConstructor
public class PatientController {
//depsy
	private final AppointmentService appointmentService;
	
	@GetMapping("/{patientId}/appointments/upcoming")
	public ResponseEntity<?> getPatientsAllAppointment(@PathVariable Long patientId)
	{
		System.out.println("in patient controller"+patientId);
		try {
			
			return ResponseEntity.ok(appointmentService.getAllAppointmentsById(patientId));
			
		}catch(RuntimeException e)
		{
			return ResponseEntity.status(HttpStatus.NOT_FOUND)
					.body(new ApiResponse("patient id not found","failure"));
		}
	}
	
	
	
	
	@PostMapping("/book/appointment")
	public ResponseEntity<?> bookPatientAppointment(@RequestBody NewAppointment newAppointment)
	{
		
		try {
			System.out.println("newAppointment "+newAppointment);
			BookedAppointment bookedAppointmentResponse =  appointmentService.addNewAppointment(newAppointment);
			
				return ResponseEntity.ok(bookedAppointmentResponse);
			
		}catch(RuntimeException e)
		{ 
			return ResponseEntity.status(HttpStatus.CONFLICT)
					.body(new ApiResponse(e.getMessage(), "Failure"));
		}
		
	}
	
}
