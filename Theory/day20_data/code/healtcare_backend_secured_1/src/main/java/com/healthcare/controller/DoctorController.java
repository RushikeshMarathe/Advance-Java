package com.healthcare.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.dto.DoctorRegDTO;
import com.healthcare.service.AppointmentService;
import com.healthcare.service.DoctorService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/doctors")
@AllArgsConstructor
public class DoctorController {
	//depcy
	private final AppointmentService appointmentService;
	private DoctorService doctorService;
	/*
	 * Desc - List doctor's upcoming appointments
End Point design
URL - http://host:port/doctors/{doctorId}/appointments/upcoming
Method- GET
resource id - path var.
Resp - List<AppointmentDTO>
Main highlight - custom query - JPQL 
i/p - user id.
	 */
	@GetMapping("/{doctorId}/appointments/upcoming")	
	@Operation(description = "List doctor's upcoming appointments")
	public  ResponseEntity<?> listUpcomingAppointments(@PathVariable Long doctorId )
	{
		System.out.println("in doctor list appointments "+doctorId);
		//invoker service layer method
		
			return ResponseEntity.ok(appointmentService.listUpcomingDoctorAppointments(doctorId));
		
	}
	/*
	 * Desc - Doctor Registration
	 * URL - http://host:port/doctors/signup
	 * Method - POST
	 * Payload - req dto 
	 * Success resp - api resp + SC 201
	 * Failed -  api resp +  SC 400
	 */
	@PostMapping("/signup")
	public ResponseEntity<?> registerDoctor(@RequestBody DoctorRegDTO dto) {
		System.out.println("in doctor reg "+dto);
		
			return ResponseEntity.status(HttpStatus.CREATED)
					.body(doctorService.registerNewDoctor(dto));
		
	}
	/*
	 * POST /doctors/{doctorId}/prescriptions
{
  "patientId": 12,
  "tests": ["Blood Test", "X-Ray", "MRI"],
  "remarks": "Suspected chest infection"
}
Meaning - 

Doctor with ID = {doctorId} is prescribing these tests for patient with ID = patientId.

Validate on the backend that both doctor and patient exist.

	 */
	

}
