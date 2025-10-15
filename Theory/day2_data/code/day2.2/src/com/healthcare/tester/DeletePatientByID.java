package com.healthcare.tester;

import java.util.Scanner;

import com.healthcare.dao.PatientDaoImpl;

public class DeletePatientByID {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc = new Scanner(System.in))
		{
			
			PatientDaoImpl service = new PatientDaoImpl();
			
		System.out.println("Enter the patient Id to Delete : ");
		System.err.println(service.deletePatient(sc.nextInt()));
		
		service.cleanUp();
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
