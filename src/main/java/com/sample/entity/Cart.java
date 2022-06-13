package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Cart")
public class Cart {
	
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
private int cartId;
@Column(name="ProductId")
private int pId;
@Column(name="Image")
private String image;
@Column(name="ProductName")
private String pName;
@Column(name="Quantity")
public int qty;
@Column(name="Price")
private double price;
@Column(name="Total_Amount")
public double total;
@ManyToOne
@OnDelete(action=OnDeleteAction.CASCADE)
@JsonIgnore
Customer customer;
public Customer getCustomer() {
	return customer;
}
public void setCustomer(Customer customer) {
	this.customer = customer;
}
public int getCartId() {
	return cartId;
}
public void setCartId(int cartId) {
	this.cartId = cartId;
}
public int getpId() {
	return pId;
}
public void setpId(int pId) {
	this.pId = pId;
}
public String getImage() {
	return image;
}
public void setImage(String image) {
	this.image = image;
}
public String getpName() {
	return pName;
}
public void setpName(String pName) {
	this.pName = pName;
}
public int getQty() {
	return qty;
}
public void setQty(int qty) {
	this.qty = qty;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public double getTotal() {
	return total;
}
public void setTotal(double total) {
	this.total = total;
}

}
