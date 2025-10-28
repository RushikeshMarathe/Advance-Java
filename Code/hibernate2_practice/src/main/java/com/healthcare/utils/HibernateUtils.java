package com.healthcare.utils;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.*;

public class HibernateUtils {
	//SessionFactory provides the Session so we need it
	
	private static SessionFactory factory;
	
	/*
	 * It's a Sigleton instance for application so we need to initialized it only once in static init
	 */
	static {
		
		 factory = new Configuration() //calling default constructor of hibernate configuration //empty
				 .configure() //populate it with properties and mapping from hibernate.cfg.xml
				 .buildSessionFactory(); //building Session factory
	}
	
	
	public static SessionFactory getFactory() {
		return factory;
	}
	
	
	/*
	 *  Flow of Session Factory
	 *  
	 *  --- When getFactory will be called 
	 *  1) First Class Load
	 *  2) static init will called
	 *  3) factory will be created and returned
	 */
	
	
	

}
