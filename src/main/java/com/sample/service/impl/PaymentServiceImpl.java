package com.sample.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sample.Exception.PaymentIdNotFoundException;
import com.sample.entity.Cart;
import com.sample.entity.Customer;
import com.sample.entity.Payment;
import com.sample.repositary.PaymentRepository;
import com.sample.service.CartService;
import com.sample.service.CustomerService;
import com.sample.service.PaymentService;
@Service
public class PaymentServiceImpl implements PaymentService {
	@Autowired
	PaymentRepository paymentRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private CartService cartService;
	public PaymentServiceImpl(PaymentRepository paymentRepository,CartService cartService,CustomerService customerService) {
		super();
		this.paymentRepository = paymentRepository;
	}

	@Override
	public Payment makePayment(Payment payment,int cId) {
		Customer customer=customerService.getCustomerById(cId);
		List<Cart> arrayList=cartService.viewAllProducts();
		List<Cart> arlist=new ArrayList<Cart>();
		for(Cart c:arrayList) {
			if(c.getCustomer()==customer) {
				arlist.add(c);
			}
						
		}
		double sum=0;
		for(Cart c1:arlist) {
			
			 sum=sum+c1.getTotal();
			 System.out.println("%%%%%%%% "+c1.getTotal());		
			payment.setTotalAmount(sum);					
		}
		payment.setCustomer(customer);
		System.out.println("##### "+arlist);
		return this.paymentRepository.save(payment);
	}

	@Override
	public List<Payment> viewPaymentDetails() {
		
		return this.paymentRepository.findAll();
	}

	@Override
	public void deletePayment(int payId) {
		this.paymentRepository.findById(payId).orElseThrow(()->new  PaymentIdNotFoundException("Product","payId",payId));
		this.paymentRepository.deleteById(payId);
	}

	@Override
	public Payment getPaymentById(int payId) {
		return this.paymentRepository.findById(payId).get();
	}

	@Override
	public Payment updatePayment(Payment payment, int payId) {
		Payment existingPayment=this.paymentRepository.findById(payId).orElseThrow(()->new  PaymentIdNotFoundException("Product","payId",payId));
		existingPayment.setCardNo(payment.getCardNo());
		this.paymentRepository.save(existingPayment);
		return existingPayment;
	}

}
