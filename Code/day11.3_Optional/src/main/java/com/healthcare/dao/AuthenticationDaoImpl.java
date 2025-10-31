package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.User;

public class AuthenticationDaoImpl implements AuthenticationDao {

	@Override
	public String RegisterUser(User newUser) {
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			 session.persist(newUser);
			 
			 User registeringUser = session.find(User.class, newUser);
			
		}catch(RuntimeException e)
		{
			
		}
		
		return null;
	}

}
