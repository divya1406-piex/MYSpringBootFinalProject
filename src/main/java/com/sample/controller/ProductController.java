package com.sample.controller;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.sample.entity.Product;
import com.sample.service.ProductService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/product")
public class ProductController {

	@Autowired
	private ProductService productService;
	
	public ProductController(ProductService productService) 
	{
		super();
		this.productService = productService;
	}
	@PostMapping
	public ResponseEntity<Product> addProduct(@RequestBody Product product)
	{
		return new ResponseEntity<Product>(productService.addProduct(product),HttpStatus.CREATED);
	}
	
	
	@GetMapping
	public List<Product> viewAllProducts()
	{
		return this.productService.viewAllProducts();
	}
	
	
	@GetMapping("{pName}")
	public ResponseEntity<Product> searchProductByName(@PathVariable("pName") String pName)
	{
		return new ResponseEntity<Product>(productService.searchProductByName(pName),HttpStatus.OK);
	}
	
	
	@GetMapping("/get/{pName}")//adding to cart
	public ResponseEntity<Product> byProduct(@PathVariable("pName") String pName)
	{
		return new ResponseEntity<Product>(productService.byProduct(pName),HttpStatus.OK);
	}
	
	
	@GetMapping("/getProduct/{pId}")
	public ResponseEntity<Product> searchProductById(@PathVariable("pId") int pId)
	{
		return new ResponseEntity<Product>(productService.searchProductById(pId),HttpStatus.OK);
	}
	
	@PutMapping("{pId}")
	public ResponseEntity<Product> updateProduct(@RequestBody Product product,@PathVariable("pId") int pId)
	{
		 return new ResponseEntity<Product>(this.productService.updateProduct(product,pId),HttpStatus.OK);
	}
	
	@DeleteMapping("{pId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("pId") int pId)
	{
		this.productService.deleteProduct(pId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
}
