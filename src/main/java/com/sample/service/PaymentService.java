package com.sample.service;

import java.util.List;

import com.sample.entity.Payment;

public interface PaymentService {
List<Payment> viewPaymentDetails();	//this is for admin
Payment makePayment(Payment payment,int cId);   //this method is for Customer
Payment getPaymentById(int payId);
Payment updatePayment(Payment payment,int payId);  
void deletePayment(int payId);
}
