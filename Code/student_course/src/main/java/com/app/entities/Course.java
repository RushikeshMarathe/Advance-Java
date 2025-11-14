package com.app.entities;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name="courses")
@NoArgsConstructor
@AllArgsConstructor
@AttributeOverride(name="id",column = @Column(name="course_id"))
@Getter
@Setter
@ToString(callSuper =true)
public class Course extends BaseEntity {
	@Column(unique = true)
	private String name;
	@Enumerated(EnumType.STRING)
	@Column(nullable = false)
	private Category category;
	@Column(name="start_date")
	private LocalDate startDate;
	@Column(name="end_date")
	private LocalDate endDate;
	
	private double fees;
	
	private int marks;
}
