package com.healthcare.repository;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Status;

public interface AppointmentRepository extends JpaRepository<Appointment, Long> 
{
// custom query - to get list of upcoming appointments by pateint id

	@Query("""
			select new
			com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName)
			from Appointment a where a.myPatient.id = :pid and a.status=:sts order by a.appointmentDateTime asc
			""")
	
	List<AppointmentDTO> getPatientUpcomingAppointmentByPatientId(@Param("pid") Long PatientId,
			@Param("sts") Status status);

	
		boolean existsByMyDoctorIdAndAppointmentDateTime(Long id,LocalDateTime timeToCheck);
	
		boolean existsByMyPatientId(Long id);
	
}
