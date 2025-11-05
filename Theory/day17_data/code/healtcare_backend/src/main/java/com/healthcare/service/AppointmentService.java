package com.healthcare.service;

import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.BookedAppointment;
import com.healthcare.dto.NewAppointment;
import com.healthcare.entities.Appointment;

public interface AppointmentService {
	
	List<AppointmentDTO> getAllAppointmentsById(Long patientId) ;

	BookedAppointment addNewAppointment(NewAppointment newAppointment);

}
