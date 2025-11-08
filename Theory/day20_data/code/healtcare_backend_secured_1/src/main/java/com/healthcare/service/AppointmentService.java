package com.healthcare.service;

import java.util.List;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.AppointmentResp;
import com.healthcare.dto.BookAppointment;
import com.healthcare.dto.CompleteAppointmentResp;

public interface AppointmentService {

	List<AppointmentDTO> listUpcomingPatientAppointments(Long patientId);

	AppointmentResp bookAppointment(Long pid, BookAppointment dto);
	List<CompleteAppointmentResp> listAllAppointments();
	List<AppointmentDTO> listUpcomingDoctorAppointments(Long doctorId);
}
