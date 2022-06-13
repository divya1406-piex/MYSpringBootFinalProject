package com.sample.service;

import java.util.List;
import com.sample.entity.Product;

public interface ProductService {
	Product addProduct(Product product);    //this method is for Admin
	List<Product> viewAllProducts();   //this function is for both Admin and Customer
	Product searchProductByName(String pName); //this function is for both Admin and Customer
	Product searchProductById(int pId);   //this function is for both Admin and Customer
	Product updateProduct(Product product,int pId);    //this method is for Admin
	void deleteProduct(int pId);     //this method is for Admin
	Product byProduct(String pName);  //this method is for Customer
	
}
