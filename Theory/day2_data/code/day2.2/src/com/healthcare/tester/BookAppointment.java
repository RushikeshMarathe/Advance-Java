package com.healthcare.tester;

import java.sql.Timestamp;
import java.util.Scanner;

import com.healthcare.dao.PatientDaoImpl;

public class BookAppointment {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc = new Scanner(System.in))
		{
			PatientDaoImpl service = new PatientDaoImpl();
			
			System.out.println("Enter Patient Id | Doctor ID |");
		System.out.println(service.BookAppointment(sc.nextInt(), sc.nextInt(),new Timestamp(System.currentTimeMillis())));
		
		service.cleanUp();
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
