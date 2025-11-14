package com.app.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="students")
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name="id",column = @Column(name="student_id"))
@Getter
@Setter
@ToString(callSuper = true)
public class Student extends BaseEntity {

	private String name;
	
	private String email;
	
	private int marks;
	
	@ManyToOne
	//@ManyToOne(cascade = CascadeType.ALL,fetch = FetchType.EAGER)
	@JoinColumn(name="course_id",nullable = false)
	private Course course;
}
