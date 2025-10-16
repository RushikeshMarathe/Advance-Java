package com.healthcare.dao;

import java.sql.Date;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.healthcare.pojos.Patient;

public interface PatientDao {
	 Patient signIn(String email, String password) throws SQLException;


	 List<Patient> displayPatientByBornDate(String startDate,String endDate) throws SQLException;
	 
	 
	 void cleanUp() throws SQLException;
	 
	 String deletePatient(int id) throws SQLException;
	 
	 
	 String BookAppointment(int doctor_id,int patient_id,Timestamp appointment_datetime) throws SQLException;

}
