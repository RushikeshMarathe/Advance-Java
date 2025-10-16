package com.healthcare.dao;

import static com.healthcare.utils.DBUtils.openConnection;

import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;

import com.healthcare.pojos.Patient;

public class PatientDaoImpl implements PatientDao{
	
	private Connection cn;
	private PreparedStatement ps1,ps2,ps3,ps4;
	
	public PatientDaoImpl() throws SQLException {
		cn = openConnection();
		ps1 = cn.prepareStatement("select * from "
				+ "patients where email = ? and password = ?");
		
		ps2 = cn.prepareStatement("select * from patients where dob between ? and ?");
		
		ps3 = cn.prepareStatement("delete from patients where id = ?");
		
		ps4 = cn.prepareStatement("insert into appointments(doctor_id,patient_id,appointment_datetime) values (?,?,?)");
	}

	@Override
	public Patient signIn(String email, String password) throws SQLException {
		
		ps1.setString(1, email);
		ps1.setString(2, password);
		
		
		try(ResultSet rs = ps1.executeQuery()){
		
		if(rs.next())
		{
			//int id, String name, String email, String phone, Date dob
			return new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getDate(6));
		}
		}
		
		return null;
	}

	
	
	@Override
	public List<Patient> displayPatientByBornDate(String startDate, String endDate) throws SQLException {
		

		List<Patient> patientToShow = new ArrayList<>();
		
		ps2.setString(1, startDate);
		ps2.setString(2, endDate);
		
System.out.println("inside");
		
		try(ResultSet rs = ps2.executeQuery()){
			
			System.out.println("inside");
			while(rs.next())
			{
				patientToShow.add(new Patient(rs.getInt(1),rs.getString(2),rs.getString(3),rs.getString(5),rs.getDate(6)));
			}
		
		}
		return patientToShow;
	}


	
	
	@Override
	public String deletePatient(int id) throws SQLException {
		// TODO Auto-generated method stub
		
		ps3.setInt(1, id);
		
		int rst = ps3.executeUpdate();
		
		if(rst == 0)
		{
			return "Failure !...";
		}else {
			return "Successfully Deleted!...";
		}
				
	}

	
	
	
	@Override
	public  String BookAppointment(int doctor_id,int patient_id,Timestamp appointment_datetime) throws SQLException{
		// TODO Auto-generated method stub
		ps4.setInt(1, doctor_id);
		ps4.setInt(2, patient_id);
		ps4.setTimestamp(3, appointment_datetime);
		
		System.out.println("inside book");
		int result = ps4.executeUpdate();
		
		if(result ==0)
		{
			return "Insertion failed";
		}else {
			return "Insertion Successfully";
		}
	}
	
	

	@Override
	public void cleanUp() throws SQLException {
		// TODO Auto-generated method stub
		if(ps1!=null)
		{
			ps1.close();
			ps1 = null;
		}
	
		
	}

	

	

	

}