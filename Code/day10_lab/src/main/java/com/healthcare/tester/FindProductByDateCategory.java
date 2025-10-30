package com.healthcare.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.healthcare.dao.ProductDao;
import com.healthcare.dao.ProductDaoImpl;
import com.healthcare.entities.Category;

public class FindProductByDateCategory {

	public static void main(String[] args) {


		try(Scanner sc = new Scanner(System.in))
		{
			ProductDao pDao= new ProductDaoImpl(); 
			System.out.println("Enter Product Date | Category");
			
			LocalDate date = LocalDate.parse(sc.next());
			Category category = Category.valueOf(sc.next());
			
			pDao.getProductByDateCategory(date,category).forEach(p-> System.out.println(p.getId()+" "+p.getName()+" "+p.getCategory()));
			
		}catch(Exception e)
		{
			System.out.println(e);
		}
	}

}
