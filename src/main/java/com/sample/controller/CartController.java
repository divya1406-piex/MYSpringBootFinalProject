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

import com.sample.entity.Cart;
import com.sample.entity.Product;
import com.sample.service.CartService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/cart")
public class CartController {
	
@Autowired
private CartService cartService;



public CartController(CartService cartService) {
	super();
	this.cartService = cartService;
}

@PostMapping
public ResponseEntity<Cart>  addProductToCart(@RequestBody Cart cart)
	{
   	
   	return new ResponseEntity<Cart>(cartService. addProductToCart(cart),HttpStatus.CREATED);
   }

@PostMapping("/add/{cId}")
public ResponseEntity<Cart>  addProductToCartByProduct(@RequestBody Product Product,@PathVariable ("cId") int cId)
{

	return new ResponseEntity<Cart>(cartService.addProductToCartByProduct(Product,cId),HttpStatus.CREATED);
}

@GetMapping
public List<Cart> viewAllProducts()
{
	return this.cartService.viewAllProducts();
}


//@GetMapping("/getProduct/{cId}")
//public ResponseEntity<Cart> getCartProductById(@PathVariable("cId") int cId)
//{
//	return new ResponseEntity<Cart>(cartService.getCartProductById(cId),HttpStatus.OK);
//}

@GetMapping("/getProduct/{cId}")
public List<Cart> getCartProductByCustomerId(@PathVariable("cId") int customerId)
{
	return  this.cartService.getCartProductByCustomerId(customerId);
}

@PutMapping("{cartId}")
public ResponseEntity<Cart> updateCartBycartId(@RequestBody Product product,@PathVariable("cartId") int cartId)
{
	 return new ResponseEntity<Cart>(this.cartService.updateCartBycartId(product,cartId),HttpStatus.OK);
}



@DeleteMapping("{cartId}")
public ResponseEntity<Boolean> deleteProductOfCart(@PathVariable("cartId") int cartId)
{
	this.cartService.deleteProductOfCart(cartId);
	boolean flag=true;
	return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
}
}
