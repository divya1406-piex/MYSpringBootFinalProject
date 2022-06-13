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
import com.sample.entity.Payment;
import com.sample.entity.Product;
import com.sample.service.PaymentService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/payment")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	public PaymentController(PaymentService paymentService) {
		super();
		this.paymentService = paymentService;
	}
	
	
	@GetMapping
	public List<Payment> viewPaymentDetails()
	{
		return this.paymentService.viewPaymentDetails();
	}
	
	@PostMapping("{cId}")
	public ResponseEntity<Payment> makePayment(@RequestBody Payment payment,@PathVariable ("cId") int cId)
	{
		 return new ResponseEntity<Payment>(this.paymentService.makePayment(payment,cId),HttpStatus.OK);
	}
	
	@GetMapping("/getPayment/{payId}")
	public ResponseEntity<Payment> getPaymentById(@PathVariable("payId") int payId)
	{
		return new ResponseEntity<Payment>(paymentService.getPaymentById(payId),HttpStatus.OK);
	}
	
	@PutMapping("{payId}")
	public ResponseEntity<Payment> updatePayment(@RequestBody Payment payment,@PathVariable("payId") int payId)
	{
		 return new ResponseEntity<Payment>(this.paymentService.updatePayment(payment,payId),HttpStatus.OK);
	}
	
	
	
	@DeleteMapping("{payId}")
	public ResponseEntity<Boolean> deleteProduct(@PathVariable("payId") int payId)
	{
		this.paymentService.deletePayment(payId);
		boolean flag=true;
		return new ResponseEntity<Boolean>(flag,HttpStatus.OK);
	}
	
}
