package com.library.tester;

import java.sql.SQLException;
import java.util.Scanner;

import com.library.daos.BookDaoImpl;

public class UpdateBookPrice {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
			try(Scanner sc = new Scanner(System.in))
			{
				BookDaoImpl bookService = new BookDaoImpl();
				System.out.println("Enter Book Id | Updated Price : ");
				System.out.println( bookService.updateBookPriceByLeastPrice(sc.nextInt(),sc.nextDouble()));
				
				bookService.closeResource();
				
			}catch(Exception e)
			{
				System.out.println(e);
			}
	}

}
