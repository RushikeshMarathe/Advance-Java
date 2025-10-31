package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.List;

import javax.management.RuntimeErrorException;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.dto.AppointmentDTO;
import com.healthcare.entities.Appointment;
import com.healthcare.entities.Doctor;
import com.healthcare.entities.Patient;
import com.healthcare.entities.Status;

public class AppointmentDaoImpl implements AppointmentDao {

	@Override
	public String bookAppointment(Long doctorId, Long patientId, LocalDateTime ts) {
		String mesg = "Appointment un available , Please choose another Date/Time";

		if(isDoctorAvailable(doctorId, ts))
		{
		
			System.out.println("doctor is available");
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		
		
		try {
			
				System.out.println("inside isDoctor if");
			Doctor doctor = session.find(Doctor.class, doctorId);
			Patient patient = session.find(Patient.class, patientId);

			Appointment appointment = new Appointment(ts, Status.SCHEDULED, doctor, patient);

			session.persist(appointment);
			mesg = "Appointment Booked Successfully!...";
			
			tx.commit();
			
			
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		}else {
			mesg ="Appointment slot already Booked!..";
		}
		
		return mesg;
	}

	@Override
	public String cancelAppointment(Long appointmentId, Long patientId) {
		// 1. Get Session from SessionFactory
		String messg = "Error in cancelling appointment";
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			Appointment app = session.find(Appointment.class, appointmentId);
			app.setStatus(Status.CANCELLED);
			tx.commit();
			messg = "Cancelled Successfully!...";
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return messg;
	}
	
	
	

	private boolean isDoctorAvailable(Long docId, LocalDateTime ts) {

		
		System.out.println("inside isDoctor start");

		LocalDateTime sTime = ts.minusMinutes(30);
		LocalDateTime eTime = ts.plusMinutes(30);
		
		System.out.println("sTime "+sTime + "eTime "+eTime);
		
		String jpql = "select a from Appointment a where a.myDoctor.id=:did and 		a.appointmentDateTime between :st and :et";

		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			List<Appointment> existingAppointment = session.createQuery(jpql,Appointment.class)
					.setParameter("did", docId)
					.setParameter("st", sTime)
					.setParameter("et", eTime)
					.getResultList();
			
			System.out.println("existing "+ existingAppointment);
			if(existingAppointment.isEmpty())
			{
				return true;
			}
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return false;
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForPatient(Long patientId) {
		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// String jpql = "select new
		// com.healthcare.entities.AppointmentDTO(a.id,a.appointmentDateTime,d.firstName)
		// from Appointment";
		String jpql = "select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment a where a.myPatient.id=:pid and a.status=:sts";
		List<AppointmentDTO> appointments;
		// 2. Begin Tx
		Transaction tx = session.beginTransaction();
		try {
			appointments = session.createQuery(jpql, AppointmentDTO.class).setParameter("pid", patientId)
					.setParameter("sts", Status.SCHEDULED).getResultList();
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return appointments;
	}

	@Override
	public List<AppointmentDTO> listUpcomingAppointmentsForDoctor(Long doctorId) {
		String jpql = "select new com.healthcare.dto.AppointmentDTO(a.id,a.appointmentDateTime,a.myDoctor.userDetails.firstName,a.myDoctor.userDetails.lastName) from Appointment where a.myPatient.id=:pid and a.status=:sts";
		List<AppointmentDTO> appointments;

		// 1. Get Session from SessionFactory
		Session session = getFactory().getCurrentSession();
		// 2. Begin Tx
		appointments = session.createQuery(jpql, AppointmentDTO.class).setParameter("pid", doctorId)
				.setParameter("sts", Status.SCHEDULED.name()).getResultList();
		Transaction tx = session.beginTransaction();
		try {
			tx.commit();
		} catch (RuntimeException e) {
			if (tx != null)
				tx.rollback();
			// re throw the exception to the caller
			throw e;
		}
		return null;

	}

}
