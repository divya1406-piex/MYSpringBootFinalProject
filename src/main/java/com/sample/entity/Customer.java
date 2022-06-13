package com.sample.entity;

import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name="Customer")
public class Customer {
@Id
@GeneratedValue(strategy=GenerationType.AUTO)

private int cId;

@Column(name="FirstName",nullable=false)
@NotEmpty
@Size(min=2 , message="firstName Must Contain atleast 2 charector")
private String fName;

@Column(name="LastName",nullable=false)
@NotEmpty
@Size(min=2 , message="laststName Must Contain atleast 2 charector")
private String lName;

@Column(name="PhoneNumber",nullable=false)
@NotEmpty
@Size(min=10 , max=10 , message="PhoneNumber Must Contain atleast 10 digits")
private String phoneNo;

@Column(name="Address",nullable=false)
private String address;

@Column(name="UserName",nullable=false)
@NotEmpty
@Email(message="Eamil address is not valid !")
public String userName;

@Column(name="Password",nullable=false)
@NotEmpty
@Size(min=5 , message="Password length Must be 5 and contain uppercase,lowercase,digits")
@Pattern(regexp="^[a-zA-Z0-9]{5,}")
public String password;

@OneToMany(mappedBy="customer",cascade=CascadeType.REMOVE)
@JsonIgnore
List<Cart> cart;

public List<Cart> getCart() {
	return cart;
}
public void setCart(List<Cart> cart) {
	this.cart = cart;
}

@OneToMany(mappedBy="customer",cascade=CascadeType.REMOVE)
List<Payment> payment;

public List<Payment> getPayment() {
	return payment;
}
public void setPayment(List<Payment> payment) {
	this.payment = payment;
}
public int getcId() {
	return cId;
}
public void setcId(int cId) {
	this.cId = cId;
}
public String getfName() {
	return fName;
}
public void setfName(String fName) {
	this.fName = fName;
}
public String getlName() {
	return lName;
}
public void setlName(String lName) {
	this.lName = lName;
}
public String getPhoneNo() {
	return phoneNo;
}
public void setPhoneNo(String phoneNo) {
	this.phoneNo = phoneNo;
}
public String getAddress() {
	return address;
}
public void setAddress(String address) {
	this.address = address;
}
public String getUserName() {
	return userName;
}
public void setUserName(String userName) {
	this.userName = userName;
}
public String getPassword() {
	return password;
}
public void setPassword(String password) {
	this.password = password;
} 

}
