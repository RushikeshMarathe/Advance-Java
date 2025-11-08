package com.healthcare.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.healthcare.service.AppointmentService;

import io.swagger.v3.oas.annotations.Operation;
import lombok.AllArgsConstructor;

@RestController
@RequestMapping("/admin")
@AllArgsConstructor
public class AdminController {
	// depcy
	private final AppointmentService appointmentService;

	/*
	 * Desc - List all appointments
	 *  End Point design 
	 *  URL -
	 * http://host:port/admin/appointments 
	 * Method- GET 
	 * Resp -
	 * List<CompleteAppointmentResp>
	 */
	@GetMapping("/appointments")
	@Operation(description = "List all appointments")
	public ResponseEntity<?> listAllAppointments() {
		System.out.println("in admin list all appointments ");
		// invoker service layer method
		
			return ResponseEntity.ok(appointmentService.listAllAppointments());
		
	}

	

}
