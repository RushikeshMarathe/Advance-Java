package com.exam.entities;

import jakarta.persistence.AttributeOverride;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
@AttributeOverride(name="id",column = @Column(name="policyId"))
public class Policy extends BaseEntity {
	
	private String policyName;
	private Long policyNo;
	private  double camt;
	private double pamt;
}
