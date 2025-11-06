package com.healthcare.repository;

import java.util.Set;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.healthcare.entities.DiagnosticTest;

@DataJpaTest
@AutoConfigureTestDatabase(replace = Replace.NONE)	
class PatientRepository {
@Autowired
private PatientRepository patientRepository;


	@Test
	Set<DiagnosticTest> getAllTestsForPatient() {
		Set<DiagnosticTest> getAllTestsForPatient = patientRepository.getAllTestsForPatient(1l);
	}

}
