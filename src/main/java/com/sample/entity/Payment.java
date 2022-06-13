package com.sample.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Payment")
public class Payment {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)
@Column(name="PaymentId",nullable=false)
private int payId;

@Column(name="CustomerName",nullable=false)
@Size(min=4 , message="Name Must Contain atleast 4 charector")
private String name;

@Column(name="ShippingAddress",nullable=false)
private String address;

@Column(name="PhoneNo",nullable=false)
@Size(min=10 , max=10 , message="PhoneNumber Must Contain atleast 10 digits")
private String phoneNo;

@Column(name="CardNo")
@Size(min=16 , max=16 , message="CardNo Must be 16 digits")
private String cardNo;

@Column(name="PaymentType",nullable=false)
private String paymentType;

@Column(name="GrandTotal")
private double totalAmount;

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
public int getPayId() {
	return payId;
}
public void setPayId(int payId) {
	this.payId = payId;
}

public String getName() {
	return name;
}
public void setName(String name) {
	this.name = name;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getCardNo() {
	return cardNo;
}
public void setCardNo(String cardNo) {
	this.cardNo = cardNo;
}

public String getPaymentType() {
	return paymentType;
}
public void setPaymentType(String paymentType) {
	this.paymentType = paymentType;
}
public double getTotalAmount() {
	return totalAmount;
}
public void setTotalAmount(double totalAmount) {
	this.totalAmount = totalAmount;
}
}
