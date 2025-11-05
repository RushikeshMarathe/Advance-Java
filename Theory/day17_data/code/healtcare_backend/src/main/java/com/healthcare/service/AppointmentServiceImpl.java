package com.healthcare.service;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.healthcare.custom_exceptions.ResourceAlreadyExists;
import com.healthcare.custom_exceptions.ResourceNotFoundException;
import com.healthcare.dto.AppointmentDTO;
import com.healthcare.dto.BookedAppointment;
import com.healthcare.dto.NewAppointment;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;
import com.healthcare.repository.AppointmentRepository;
import com.healthcare.repository.DoctorRepository;
import com.healthcare.repository.PatientRepository;

import lombok.AllArgsConstructor;

@Service
@Transactional
@AllArgsConstructor
public class AppointmentServiceImpl implements AppointmentService {

	private final ModelMapper modelMapper;
	private final AppointmentRepository appointmentRepository;
	private final PatientRepository patientRepository;
	private final DoctorRepository doctorRepository;

	@Override
	public List<AppointmentDTO> getAllAppointmentsById(Long patientId) {

		return appointmentRepository.getPatientUpcomingAppointmentByPatientId(patientId, Status.SCHEDULED);
	}

	@Override
	public BookedAppointment addNewAppointment(NewAppointment newAppointment) {

		// Validating existing user or not
		Doctor doctor = doctorRepository.findById(newAppointment.getDoctorId())
				.orElseThrow(() -> new ResourceNotFoundException("Doctor does not exists!.."));
		Patient patient = patientRepository.findById(newAppointment.getPatientId())
				.orElseThrow(() -> new ResourceNotFoundException("Patient does not exists!..."));

		// checking for appointment slot
		if (!appointmentRepository.existsByMyDoctorIdAndAppointmentDateTime(newAppointment.getDoctorId(),
				newAppointment.getAppointmentDateTime())) {

			/*
			 * ------ PENDING -----
			 */
//				Appointment appointmentToInsert = modelMapper.map(newAppointment, Appointment.class);
//				System.out.println("appointmentToInsert"+appointmentToInsert);
//				Appointment bookedNewAppointment  = appointmentRepository.save(appointmentToInsert);
//				System.out.println("bookedNewAppointment"+appointmentToInsert);

			// creating instance for saving appointment in database
			Appointment appointment = new Appointment();
			appointment.setMyDoctor(doctorRepository.findById(newAppointment.getDoctorId()).orElseThrow());
			appointment.setMyPatient(patientRepository.findById(newAppointment.getPatientId()).orElseThrow());
			appointment.setAppointmentDateTime(newAppointment.getAppointmentDateTime());
			Appointment bookedNewAppointment = appointmentRepository.save(appointment);

//				Appointment resBookedAppointment = new Appointment();
//				BookedAppointment resBookedAppointment = modelMapper.map(bookedNewAppointment,BookedAppointment.class);

			// creating DTO for sending response
			BookedAppointment resBookedAppointment = new BookedAppointment();
			resBookedAppointment.setAppointmentDateTime(bookedNewAppointment.getAppointmentDateTime());
			resBookedAppointment.setAppointmentId(bookedNewAppointment.getId());
			resBookedAppointment.setDoctorName(bookedNewAppointment.getMyDoctor().getUserDetails().getFirstName());
			resBookedAppointment.setMessage("Appointment Booked!..");
			resBookedAppointment.setStatus(bookedNewAppointment.getStatus());
			return resBookedAppointment;
		} else {
			throw new ResourceAlreadyExists("Appointment Already Booked!...");
		}

	}

}
