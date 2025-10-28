package com.healthcare.dao;

import com.healthcare.entities.User;


import static com.healthcare.utils.HibernateUtils.getFactory;

import org.hibernate.Session;
import org.hibernate.Transaction;

public class UserDaoImpl implements UserDao {

	

	
	@Override
	public String signUp(User newUser) {
		// TODO Auto-generated method stub
		
		Session session = getFactory().getCurrentSession();
		Transaction tx = session.beginTransaction();
		try
		{
			session.persist(newUser);
			tx.commit();
		}catch(Exception e)
		{
			tx.rollback();
		}
		
		
		
		return "Successfully Signup";
	}

}
