package com.healthcare.tester;

import java.time.LocalDate;
import java.util.Scanner;

import com.healthcare.dao.ProductDao;
import com.healthcare.dao.ProductDaoImpl;
import com.healthcare.entities.Category;
import com.healthcare.entities.Product;

public class AddNewProduct {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try (Scanner sc = new Scanner(System.in)) {
			ProductDao pDao = new ProductDaoImpl();

			System.out.println("---- Enter Product Details to add ----");

			// String name, String description, LocalDate mfg, double price, int quantity,
			// Category category
			System.out.println("Product Name | Description | Manufacturing Date | Price | Quantity | Category");
			String addStatus = pDao.addNewProduct(new Product(sc.next(), sc.nextLine(), LocalDate.parse(sc.next()),
					sc.nextDouble(), sc.nextInt(), Category.valueOf(sc.next().toUpperCase())));
			
			System.out.println(addStatus);

		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
