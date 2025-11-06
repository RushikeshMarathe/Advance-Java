package com.healthcare.repository;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase;
import org.springframework.boot.test.autoconfigure.jdbc.AutoConfigureTestDatabase.Replace;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Status;

@DataJpaTest // 
@AutoConfigureTestDatabase(replace = Replace.NONE)
class AppointmentRepositoryTest {
//Field Level D.I.
	@Autowired
	private AppointmentRepository appointmentRepository;
	
	@Test
	void getPatientUpcomingAppointmentsByUserId() {
		List<AppointmentDTO> list = appointmentRepository.getPatientUpcomingAppointmentsByUserId(3l,Status.SCHEDULED);
		assertEquals(5, list.size());
		//assertEquals(1l,list.get(0).getAppointmentId());
	}

}
