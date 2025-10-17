package com.healthcare.dao;

import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.List;

import com.healthcare.pojos.Appointment;
import com.healthcare.pojos.Patient;

public interface AppointmentDao {
	
	 List<Appointment> getAppointment(int id) throws SQLException;
	 
	 void clean() throws SQLException;
	 
	 
	 boolean bookAppointment(int did,int pid,Timestamp appointment_dtime,String doctorName) throws SQLException;


}
