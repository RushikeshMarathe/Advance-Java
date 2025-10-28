package com.healthcare.tester;

import org.hibernate.Session;
import static com.healthcare.utils.HibernateUtils.getFactory;

public class Test1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		Session session = getFactory().getCurrentSession();
		
		if(session != null)
		{
			System.out.println("Session successfully created!...");
		}else {
			System.out.println("Session Failed!...");
		}

	}

}
