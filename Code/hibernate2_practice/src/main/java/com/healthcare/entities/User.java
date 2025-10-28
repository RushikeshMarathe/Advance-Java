package com.healthcare.entities;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;

@Entity(name = "users")
public class User {
	
	// id | dob | email | first_name | image
	//| last_name | password | phone      | role  
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	@Column(name = "first_name")
	private String firstname;
	@Column(name = "last_name")
	private String lastname;
	@Column(length = 20, unique = true)
	private String email;
	@Column(nullable = false)
	private String password;
	@Column(length = 13)
	private String phone;
	@Lob
	private byte[] image;
	private LocalDate dob;
	@Enumerated(EnumType.STRING)
	private UserRole role;
	
	
	
	
	public User(String firstname, String lastname, String email, String password, String phone,LocalDate dob, UserRole role) {
		super();
		this.firstname = firstname;
		this.lastname = lastname;
		this.email = email;
		this.password = password;
		this.phone = phone;
		this.dob = dob;
		this.role = role;
	}




	public Long getId() {
		return id;
	}




	public void setId(Long id) {
		this.id = id;
	}




	public String getFirstname() {
		return firstname;
	}




	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}




	public String getLastname() {
		return lastname;
	}




	public void setLastname(String lastname) {
		this.lastname = lastname;
	}




	public String getEmail() {
		return email;
	}




	public void setEmail(String email) {
		this.email = email;
	}




	public String getPassword() {
		return password;
	}




	public void setPassword(String password) {
		this.password = password;
	}




	public String getPhone() {
		return phone;
	}




	public void setPhone(String phone) {
		this.phone = phone;
	}




	public byte[] getImage() {
		return image;
	}




	public void setImage(byte[] image) {
		this.image = image;
	}




	public UserRole getRole() {
		return role;
	}




	public void setRole(UserRole role) {
		this.role = role;
	}
	
	
	

}
