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
		} catch (RuntimeException e) {
			if (tx != null) {
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

			foundProduct = session.find(Product.class, productId);
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}

		return foundProduct;
	}

	@Override
	public List<Product> getProductByDateCategory(LocalDate date, Category category) {
		String jpql = "select new com.healthcare.entities.Product(p.id,p.name,p.category) from Product p where p.mfg < :sdate and p.category = :scategory";

		List<Product> foundProducts;
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {

			foundProducts = session.createQuery(jpql, Product.class).setParameter("sdate", date)
					.setParameter("scategory", category).getResultList();
			tx.commit();

		} catch (RuntimeException e) {
			if (tx != null) {
				tx.rollback();
			}

			throw e;
		}

		return foundProducts;
	}

	@Override
	public String changeProductName(Long id,double price) {
		String errMessage = "Product price not change";
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			Product productToChange = session.find(Product.class, id);

			if (productToChange != null) {
				productToChange.setPrice(price);
				
				
			}else {
				 errMessage = "Product is empty";
			}
			
			tx.commit();
			errMessage= "Successfully Price changed";
		} catch (RuntimeException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}

		return errMessage;
	}

	@Override
	public String applyDiscountToAll(int quantity, double discount) {
		String messg = "Error in applying discount!";
		String jpql = "update Product p set p.price = p.price - (p.price*(:disc/100)) "
				+ "where quantity > :qty";
		
		Session session = getFactory().getCurrentSession();

		Transaction tx = session.beginTransaction();

		try {
			
			int result = session.createMutationQuery(jpql)
					.setParameter("disc", discount)
					.setParameter("qty", quantity)
					.executeUpdate();
			
			
			tx.commit();
			messg= "Successfully Discount applied to "+result+" products";
		} catch (RuntimeException e) {
			if(tx!=null)
			{
				tx.rollback();
			}
			throw e;
		}

		return messg;
	}

}
