package com.ems.value_types;

import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
//JPA
@Embeddable
public class AdhaarCard {
	@Column(unique = true, length = 16)
	private String cardNumber;	
	private LocalDate creationDate;
	@Column(length = 50)
	private String location;
}
