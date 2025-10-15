package com.library.tester;

import com.library.daos.BookDaoImpl;

public class DisplayBookOrderByPrice {
	
	public static void main(String args[]) {
		
		try {
			
			BookDaoImpl bookService = new BookDaoImpl();
			
			bookService.getAllBooksData().forEach(f->System.out.println(f));
			
			
			bookService.closeResource();
			
			
			
		}catch(Exception e)
		{
			e.getStackTrace();
		}
	}

}
