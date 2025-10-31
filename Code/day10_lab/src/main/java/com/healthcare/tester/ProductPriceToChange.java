package com.healthcare.tester;

import java.util.Scanner;

import com.healthcare.dao.ProductDao;
import com.healthcare.dao.ProductDaoImpl;

public class ProductPriceToChange {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			ProductDao pDao = new ProductDaoImpl();
			System.out.println("Enter Product ID | Price to change(Increase)");
			System.out.println(pDao.changeProductName(sc.nextLong(), sc.nextDouble()));
		}catch(Exception e)
		{
			System.out.println(e);
		}
		
	}

}
