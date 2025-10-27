package com.healthcare.tester;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.SessionFactory;


public class TestHibernate {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		try(SessionFactory factory =getFactory() )
		{
			
		}catch(Exception e)
		{
			
		}

	}

}
