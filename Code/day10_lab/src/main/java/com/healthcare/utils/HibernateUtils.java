package com.healthcare.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtils {
	
	// declaring Session factory instance
	private static SessionFactory factory;
	
	static {
		factory = new Configuration()   //calling default constructor with blank
				  .configure()			//populating it with all the property and mapping from hm.cfg.xml
				  .buildSessionFactory(); //building session factory singlton ,immutable instance
	}
	
	public static SessionFactory getFactory() {
		return factory;
	}

}
