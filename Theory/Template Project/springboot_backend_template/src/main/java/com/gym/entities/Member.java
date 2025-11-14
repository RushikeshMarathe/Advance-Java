package com.gym.entities;

import java.time.LocalDate;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@AttributeOverride(name="id",column = @Column(name="memberId"))
public class Member extends BaseEntity {
	@Column(nullable = false)
	private String name;
	@Column(nullable = false,unique = true)
	private String email;
	
	private int weight;
	
	private Long height;
	@Enumerated(EnumType.STRING)
	private MemberType memberType;
	
	private LocalDate joinDate;
	
	@ManyToOne
	@JoinColumn(name="trainerId")
	private Trainer trainer;
}
