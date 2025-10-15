package com.library.tester;

import java.util.Scanner;

import com.library.daos.BookDaoImpl;

public class InsertNewRecord {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		try(Scanner sc = new Scanner(System.in))
		{
			
			BookDaoImpl bookService = new BookDaoImpl();
			
			System.out.println("Enter Book Title, Author, Price");
			System.out.println( bookService.insertNewRecord(sc.nextLine(), sc.next(), sc.nextDouble()));
			
			
			bookService.closeResource();
			
			
			
		}catch(Exception e)
		{
			System.out.println(e.getStackTrace());
			System.err.println(e);
		}
	}

}
