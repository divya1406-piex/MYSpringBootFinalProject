package com.sample.service.impl;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.Exception.CartProductNotFoundException;
import com.sample.entity.Cart;
import com.sample.entity.Customer;
import com.sample.entity.Product;
import com.sample.repositary.CartRepository;
import com.sample.service.CartService;
import com.sample.service.CustomerService;
@Service
public class CartServiceImpl implements CartService {
	static int productId=0,customerId=0;
	@Autowired
    CartRepository cartRepository;
	
	@Autowired
	private CustomerService customerService;

	
	public CartServiceImpl(CartRepository cartRepository,
			CustomerService customerService) {
		super();
		this.cartRepository = cartRepository;
		this.customerService = customerService;
	}


	@Override
	public Cart addProductToCart(Cart cart) {
		return cartRepository.save(cart);
		 
	}
	

	@Override
	public Cart addProductToCartByProduct(Product product,int cId) {
		
		
		if(productId==product.getpId() && customerId==cId) {
			
			Customer customer=customerService.getCustomerById(cId);
			Cart cart=findCartByPidAndCustomer(product.getpId(),customer);
			Cart cart1=updateCartBycartId(product,cart.getCartId());
			productId=product.getpId();
			customerId=cId;
			return cart1;
		}
		else
		{
		Cart cart=new Cart();
		Customer customer=customerService.getCustomerById(cId);
		cart.setpId(product.getpId());
		cart.setImage(product.getImage());
		cart.setpName(product.getpName());
    	cart.setQty(product.getuQty());
		cart.setPrice(product.getPrice());
		cart.total=(cart.qty*product.getPrice());
		cart.setCustomer(customer);
		productId=product.getpId();
		customerId=cId;
		return this.cartRepository.save(cart);
		}
		
	}

	@Override
	public List<Cart> viewAllProducts() {
		return this.cartRepository.findAll();
	}

	@Override
	public Cart getCartProductById(int cId) {
		
		return this.cartRepository.findById(cId).get();
	}

	@Override
	public Cart updateCartBycartId(Product product, int cartId) {
		Cart existingCart=this.cartRepository.findById(cartId).orElseThrow(()->new CartProductNotFoundException("cart Product not found.. "));
		existingCart.setImage(product.getImage());
		existingCart.setpName(product.getpName());
		existingCart.setPrice(product.getPrice());
		existingCart.setQty(existingCart.getQty()+product.getuQty());
		existingCart.setTotal(existingCart.getQty()*existingCart.getPrice());
		this.cartRepository.save(existingCart);
		return existingCart;
	}

	@Override
	public void deleteProductOfCart(int cartId) {
		cartRepository.findById(cartId).orElseThrow(()->new  CartProductNotFoundException("Product Not Found"));
		this.cartRepository.deleteById(cartId);	
		
	}


	@Override
	public List<Cart> getCartProductByCustomerId(int customerId) {
		
		List<Cart> arrayList=new ArrayList<Cart>();
		List<Cart> list=viewAllProducts();
		Iterator<Cart> it=list.iterator();
		while(it.hasNext())
		{
			Cart cart=it.next();
			if(customerId==cart.getCustomer().getcId()) {
				arrayList.add(cart);
			}
		}
		return arrayList;
	}


	@Override
	public Cart findCartByPidAndCustomer(int pId, Customer customer) {
		
		return this.cartRepository.findBypIdAndCustomer(pId,customer);
		
	}

}
