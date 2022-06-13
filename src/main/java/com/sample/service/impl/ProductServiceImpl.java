package com.sample.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.Exception.ProductNotFoundException;
import com.sample.entity.Product;
import com.sample.repositary.ProductRepository;
import com.sample.service.ProductService;

@Service
public class ProductServiceImpl implements ProductService{
	@Autowired
	private ProductRepository productRepository;
	
	public ProductServiceImpl(ProductRepository productRepository) {
		super();
		this.productRepository = productRepository;
	}
	@Override
	public Product addProduct(Product product) {
		
		return this.productRepository.save(product);
	}

	@Override
	public List<Product> viewAllProducts() {
		
		return this.productRepository.findAll();
	}

	@Override
	public Product searchProductByName(String pName) {

		
		return this.productRepository.findBypName(pName).get();
	}
	
	
	@Override
	public Product searchProductById(int pId) {

		return this.productRepository.findById(pId).get();
	}

	
	@Override
	public Product byProduct(String pName) {
		return this.productRepository.findBypName(pName).get();
	}
	
	
	@Override
	public Product updateProduct(Product product, int pId) {
		
		Product existingProduct=this.productRepository.findById(pId).orElseThrow(()->new ProductNotFoundException("Product","pId",pId));
		existingProduct.setImage(product.getImage());
		existingProduct.setpName(product.getpName());
		existingProduct.setQty(product.getQty());
		existingProduct.setPrice(product.getPrice());
		this.productRepository.save(existingProduct);
		return existingProduct;
	}
	
	
	@Override
	public void deleteProduct(int pId) {
		productRepository.findById(pId).orElseThrow(()->new  ProductNotFoundException("Product","pId",pId));
		this.productRepository.deleteById(pId);
		
	}
	
}
