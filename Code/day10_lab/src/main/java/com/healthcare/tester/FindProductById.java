package com.healthcare.tester;

import java.util.Scanner;

import com.healthcare.dao.ProductDao;
import com.healthcare.dao.ProductDaoImpl;

public class FindProductById {

	
	public static void main(String[] args)
	{
		try(Scanner sc = new Scanner(System.in))
		{
			ProductDao pDao= new ProductDaoImpl(); 
			System.out.println("Enter Product Id to found product");
			
			System.out.println(pDao.getProductById(sc.nextLong()));
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}
}

