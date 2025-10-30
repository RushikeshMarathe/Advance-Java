package com.healthcare.dao;

import java.time.LocalDate;
import java.util.List;

import com.healthcare.entities.Category;
import com.healthcare.entities.Product;

public interface ProductDao {

	//adding new product id
	
	public String addNewProduct(Product newProduct);
	
	public Product getProductById(Long productId);
	
	public List<Product> getProductByDateCategory(LocalDate date,Category category);
}
