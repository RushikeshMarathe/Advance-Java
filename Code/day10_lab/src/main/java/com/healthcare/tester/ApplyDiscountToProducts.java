package com.healthcare.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.healthcare.dao.ProductDao;
import com.healthcare.dao.ProductDaoImpl;
import com.healthcare.entities.Category;

public class ApplyDiscountToProducts {

	public static void main(String[] args) {
		
		try(Scanner sc = new Scanner(System.in))
		{
			ProductDao pDao= new ProductDaoImpl(); 
			System.out.println("Enter Quantity | Discount");
			
			System.out.println(pDao.applyDiscountToAll(sc.nextInt(), sc.nextDouble()));
			
			
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
