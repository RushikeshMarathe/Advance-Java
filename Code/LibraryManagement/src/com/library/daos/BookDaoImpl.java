package com.library.daos;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import static com.library.utils.dbConnection.*;

import com.library.pojos.Book;

public class BookDaoImpl implements BookDao {
	private Connection cn;
	private Statement st;
	private PreparedStatement pst1,pst2;
	
	public BookDaoImpl() throws SQLException {
		cn = dbConnect();
		st = cn.createStatement();
		
		pst1 = cn.prepareStatement("insert into books values(default,?,?,?)");
		
		pst2 = cn.prepareStatement("update books set price = ? where book_id = ?");
		
	}

	@Override
	public List<Book> getAllBooksData() throws SQLException {
		// TODO Auto-generated method stub
		List<Book> Books = new ArrayList<>();
		
	
		try(ResultSet rst = st.executeQuery("select * from books order by price desc")){
			while(rst.next())
			{
				Books.add(new Book(rst.getInt(1),rst.getString(2),rst.getString(3),rst.getDouble(4)));
			}
		}

		
		return Books;
	}
	
	
	
	
	
	
	public void closeResource() throws SQLException {
		if(st!=null)
		{
			st.close();
			st=null;
		}
	}

	@Override
	public String insertNewRecord(String title,String author,double price) throws SQLException {
		// TODO Auto-generated method stub
		
		pst1.setString(1, title);
		pst1.setString(2, author);
		pst1.setDouble(3, price);
		
		int resultStatus = pst1.executeUpdate();
		
		
		if(resultStatus==0)
		{
			return "Unsuccessful Insertion!....";
		}
		return "Successfully Insertion!...";
	}
	
	
	
	
		public String updateBookPriceByLeastPrice(int idToUpdate,double priceToUpdate) throws SQLException{
			pst2.setInt(2, idToUpdate);
			pst2.setDouble(1, priceToUpdate);
			
			int resultStatus = pst2.executeUpdate();
			
			if(resultStatus == 0)
			{
				return "Unsuccessfull in updation!...";
			}
			
			return "Successfully Updation!...";
			
		}
	
	
	

}
