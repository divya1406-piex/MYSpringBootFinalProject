package com.sample.service;

import java.util.List;

import com.sample.entity.Cart;
import com.sample.entity.Customer;
import com.sample.entity.Product;


public interface CartService {
Cart addProductToCart(Cart cart);
//Cart addProductToCartById(int cartId);
Cart addProductToCartByProduct(Product product,int cId);
List<Cart> viewAllProducts();
Cart getCartProductById(int cId);
List<Cart> getCartProductByCustomerId(int customerId);
Cart updateCartBycartId(Product product,int cartId);
void deleteProductOfCart(int cartId);
Cart findCartByPidAndCustomer(int pId,Customer customer);
}
