package com.healthcare.tester;

import java.util.Scanner;

import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

public class PatientSignIn {
	
	public static void main(String args[]) 
	{
		
		
		
		try(Scanner sc = new Scanner(System.in))
		{
			PatientDaoImpl service = new PatientDaoImpl();
			
			
			System.out.println("\nEnter Email | Password ");
			Patient signInPatient = service.signIn(sc.next(), sc.next());
			
			if(signInPatient != null)
			{
				System.out.println("Successfully Sign in for "+ signInPatient.getEmail() +" "+signInPatient.getPassword());
			}else {
				System.out.println("Invalid Crdentials!...");
			}
			
			service.cleanUp();
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
