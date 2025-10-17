package com.healthcare.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import static com.healthcare.utils.DBUtils.*;

import com.healthcare.pojos.Appointment;

public class AppointmentDaoImpl implements AppointmentDao {
	
	PreparedStatement ps1,ps2;
	List<Appointment> fetchAppointment = new ArrayList<>();
	
	public AppointmentDaoImpl() throws SQLException {
		// TODO Auto-generated constructor stub
		
		Connection cn = openConnection();
		ps1 = cn.prepareStatement("select a.id,a.appointment_datetime,p.name from appointments a inner join "
				+ "Patients p on a.doctor_id = p.id where a.appointment_datetime > date_sub(curdate(),interval 30 day) and a.id = ?");
	
		
		ps2 = cn.prepareStatement("insert into appointments values(default,?,?,?,'SCHEDULED')");
	} 
	

	@Override
	public List<Appointment> getAppointment(int id) throws SQLException {
		// TODO Auto-generated method stub
		ps1.setInt(1, id);
		ResultSet rst = ps1.executeQuery();
		
		while(rst.next()) {
			fetchAppointment.add(new Appointment(rst.getInt(1), rst.getTimestamp(2),rst.getString(3)));
		}
		
		
		return fetchAppointment;
	}
	
	

	@Override
	public void clean() throws SQLException {
		// TODO Auto-generated method stub
		closeConnection();
		
	}

	@Override
	public boolean bookAppointment(int did,int pid,Timestamp appointment_dtime,String doctorName) throws SQLException {
		// TODO Auto-generated method stub
		
		ps2.setInt(1, did);
		ps2.setInt(2, pid);
		ps2.setTimestamp(2, appointment_dtime);
		
		
		return false;
	}
	
	

}
