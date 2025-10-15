package com.healthcare.tester;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.healthcare.dao.PatientDaoImpl;
import com.healthcare.pojos.Patient;

public class DisplayPatientInDateRange {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(Scanner sc = new Scanner(System.in))
		{
			PatientDaoImpl service = new PatientDaoImpl();
			
			//service.displayPatientByBornDate("1990-12-12","1989-10-10").stream().forEach(a->System.out.println(a));
//			dao.findBySpeciality(sc.next())
//			.forEach(System.out::println);
			
			service.displayPatientByBornDate("1989-10-10","1990-12-12").forEach(System.out::println);
			
			List<Patient> abc = new ArrayList<>();
			
			
			service.cleanUp();
		}catch(Exception e)
		{
			e.getStackTrace();
		}

	}

}
