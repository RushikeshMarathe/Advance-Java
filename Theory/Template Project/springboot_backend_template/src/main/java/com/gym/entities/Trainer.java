package com.gym.entities;

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

@Entity
@Table(name="trainers")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name = "id",column = @Column(name="trainerId"))
public class Trainer extends BaseEntity {
@Column(nullable = false)
private String name;	
@Enumerated(EnumType.STRING)
private Specialization specialization;
@Column(nullable = false)
private Long experienceYears;
@Column(nullable = false)
private String contactNumber;

	
}
