package com.library.daos;

import java.sql.SQLException;
import java.util.List;

import com.library.pojos.Book;

public interface BookDao {
	
	//Read from CRUD
	List<Book> getAllBooksData() throws SQLException;
	
	String insertNewRecord(String title,String author,double price) throws SQLException;
	
	String updateBookPriceByLeastPrice(int idToUpdate,double priceToUpdate) throws SQLException;
	
	
	void closeResource() throws SQLException;
	
	

}
