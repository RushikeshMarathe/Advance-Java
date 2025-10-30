package com.healthcare.dao;

import static com.healthcare.utils.HibernateUtils.getFactory;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import com.healthcare.entities.Category;
import com.healthcare.entities.Product;

public class ProductDaoImpl implements ProductDao {

	@Override
	public String addNewProduct(Product newProduct) {
		// TODO Auto-generated method stub
		
		String messg = "Insertion failed!..";
		
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
	
		try {
		session.persist(newProduct);
		
		tx.commit();
		messg = "Insertion Successfull";
		}catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			
			throw e;
		}
		
		return messg;
	}

	@Override
	public Product getProductById(Long productId) {
		Product foundProduct = null;

		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			foundProduct =  session.find(Product.class, productId);
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			
			throw e;
		}
		
		return foundProduct;
	}


	@Override
	public List<Product> getProductByDateCategory(LocalDate date, Category category) {
		String jpql = "select new com.healthcare.entities.Product(p.id,p.name,p.category) from Product p where p.mfg < :sdate and p.category = :scategory";
		
		List<Product> foundProducts ;
		Session session = getFactory().getCurrentSession();
		
		Transaction tx = session.beginTransaction();
		
		try {
			
			foundProducts =  session.createQuery(jpql,Product.class).getResultList();
			tx.commit();
			
		}catch(RuntimeException e)
		{
			if(tx!=null)
			{
				tx.rollback();
			}
			
			throw e;
		}
		
		return foundProducts;
	}	
	

}
