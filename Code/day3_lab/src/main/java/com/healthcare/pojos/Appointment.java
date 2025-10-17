package com.healthcare.pojos;

import java.sql.Timestamp;
import java.time.LocalDateTime;

public class Appointment {
	
	private int id;
	private int doctor_id;
	private int patient_id;
	private Timestamp appointment_datetime;
	private String doctorName;
	private String status;
	
	
	
	
	



	public String getDoctorName() {
		return doctorName;
	}



	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}



	public Appointment(int id, Timestamp appointment_datetime, String doctorName) {
		super();
		this.id = id;
		this.appointment_datetime = appointment_datetime;
		this.doctorName = doctorName;
	}



	public int getId() {
		return id;
	}



	public void setId(int id) {
		this.id = id;
	}



	public int getDoctor_id() {
		return doctor_id;
	}



	public void setDoctor_id(int doctor_id) {
		this.doctor_id = doctor_id;
	}



	public int getPatient_id() {
		return patient_id;
	}



	public void setPatient_id(int patient_id) {
		this.patient_id = patient_id;
	}



	public Timestamp getAppointment_datetime() {
		return appointment_datetime;
	}



	public void setAppointment_datetime(Timestamp appointment_datetime) {
		this.appointment_datetime = appointment_datetime;
	}



	public String getStatus() {
		return status;
	}



	public void setStatus(String status) {
		this.status = status;
	}
	

	
}
