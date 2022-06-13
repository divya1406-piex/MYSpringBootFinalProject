package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

@Entity
@Table(name="Product")
public class Product {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="ProductId",nullable=false)
private int pId;

@Column(name="Image",nullable=false)
private String image;

@Column(name="ProductName",nullable=false)
@Size(min=2 , message="productName Must Contain atleast 2 charector")
private String pName;

@Column(name="Quantity",nullable=false)
private int qty;

@Column(name="userQuantity")
private int uQty;

@Column(name="Price",nullable=false)
private double price;

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

public int getuQty() {
	return uQty;
}
public void setuQty(int uQty) {
	this.uQty = uQty;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}

}
