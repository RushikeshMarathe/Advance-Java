package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDateTime;
import java.util.Scanner;

import org.hibernate.SessionFactory;

import com.healthcare.dao.AppointmentDao;
import com.healthcare.dao.AppointmentDaoImpl;

public class CancelAppointment {

	public static void main(String args[])
	{
		try (Scanner sc=new Scanner(System.in);   SessionFactory sf = getFactory()) {
			AppointmentDao appointmentDao=new AppointmentDaoImpl();
			System.out.println("Enter Appointment Id | Patient Id |");
			System.out.println(appointmentDao.cancelAppointment(sc.nextLong(),sc.nextLong()));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
