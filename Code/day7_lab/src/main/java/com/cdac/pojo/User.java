package com.cdac.pojo;

import java.time.LocalDate;

public class User {
	
	private String name;
	private String password;
	private LocalDate dob;
	public String getName() {
		return name;
	}



	public void setName(String name) {
		this.name = name;
	}



	public String getPassword() {
		return password;
	}



	public void setPassword(String password) {
		this.password = password;
	}



	public LocalDate getDob() {
		return dob;
	}



	public void setDob(LocalDate dob) {
		this.dob = dob;
	}



	public String getEmail() {
		return email;
	}



	public void setEmail(String email) {
		this.email = email;
	}



	private String email;
	
	
	public User(String name, String password, LocalDate dob, String email) {
		super();
		this.name = name;
		this.password = password;
		this.dob = dob;
		this.email = email;
	}
	
	
	
	@Override
	public String toString() {
		return "User [name=" + name + ", dob=" + dob + ", email=" + email + "]";
	}
	
	
	
	

}
