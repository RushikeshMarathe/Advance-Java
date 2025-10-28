package com.healthcare.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.healthcare.dao.UserDao;
import com.healthcare.dao.UserDaoImpl;
import com.healthcare.entities.User;
import com.healthcare.entities.UserRole;

public class UserTester {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		/*
		 * String firstname, String lastname, String email, String password, String phone, UserRole role
		 */
		try(Scanner sc = new Scanner(System.in)){
		System.out.println("Enter User Details"
				+ "FirstName | LastName | Email | Password | Phone | Role");
		
		UserDao userDao = new UserDaoImpl();
		/*
		 * String firstname, String lastname, 
		 * String email,
		 *  String password, String phone,
		 *  LocalDate dob, UserRole role
		 */
		String messg = userDao.signUp(new	 		User(sc.next(),sc.next(),sc.next(),sc.next(),sc.next(),LocalDate.parse(sc.next()),UserRole.valueOf(sc.next())));
		
		System.out.println(messg);
		}catch (RuntimeException e) {
			// TODO: handle exception
			System.out.println(e);
		}

	}

}
