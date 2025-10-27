package com.healthcare.dto;

import java.sql.Timestamp;

public class DoctorAppointment {
	private String patientName;
	private String phoneNo;
	private Timestamp dTime;
	private String status;
	private int id;
	
	
	public String getStatus() {
		return status;
	}


	public void setStatus(String status) {
		this.status = status;
	}


	public String getPatientName() {
		return patientName;
	}


	@Override
	public String toString() {
		return "DoctorAppointment [patientName=" + patientName + ", phoneNo=" + phoneNo + ", dTime=" + dTime + "]";
	}


	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}


	public String getPhoneNo() {
		return phoneNo;
	}


	public void setPhoneNo(String phoneNo) {
		this.phoneNo = phoneNo;
	}


	public Timestamp getdTime() {
		return dTime;
	}


	public void setdTime(Timestamp dTime) {
		this.dTime = dTime;
	}


	public DoctorAppointment(String patientName, String phoneNo, Timestamp dTime,String status,int id) {
		super();
		this.patientName = patientName;
		this.phoneNo = phoneNo;
		this.dTime = dTime;
		this.status = status;
		this.id = id;
	}


	public int getId() {
		return id;
	}


	public void setId(int id) {
		this.id = id;
	}
}
