package com.sample.controller;

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

import com.sample.Exception.CustomerNotFoundException;
import com.sample.entity.Customer;
import com.sample.service.CustomerService;
@CrossOrigin(origins="http://localhost:4200")
@RestController
@RequestMapping("api/customer")
public class CustomerController {
	
@Autowired
private CustomerService customerService;


public CustomerController(CustomerService customerService) {
	super();
	this.customerService = customerService;
}


@GetMapping("/get/{cId}")
public ResponseEntity<Customer> getCustomerById(@PathVariable("cId") int cId)
{
	return new ResponseEntity<Customer>(customerService.getCustomerById(cId),HttpStatus.OK);
}

@GetMapping("/g/{userName}")
public ResponseEntity<Customer> getCustomerByUserName(@PathVariable("userName") String userName)
{
	return new ResponseEntity<Customer>(customerService.getCustomerByUserName(userName),HttpStatus.OK);
}

@PostMapping
public ResponseEntity<Customer> registerCustomer(@Valid @RequestBody Customer customer)//taking json data as object we use @requestbody
{
	System.out.println(customer);
	return new ResponseEntity<Customer>(customerService.registerCustomer(customer),HttpStatus.CREATED);
}


@PostMapping("/login")
public  ResponseEntity<Customer> loginCustomer(@RequestBody Customer customer)throws CustomerNotFoundException
{
	return new ResponseEntity<Customer> (	customerService.loginCustomer(customer),HttpStatus.OK);
	
}


@PutMapping("{cId}")
public ResponseEntity<Customer> updateCustomer(@Valid @RequestBody Customer customer,@PathVariable("cId") int cId)
{
	 return new ResponseEntity<Customer>(this.customerService.updateCustomer(customer,cId),HttpStatus.OK);
}

@PutMapping("/up/{userName}")
public ResponseEntity<Customer> updateCustomerByUserName(@Valid @RequestBody Customer customer,@PathVariable("userName") String userName)
{
	 return new ResponseEntity<Customer>(this.customerService.updateCustomerByUserName(customer,userName),HttpStatus.OK);
}



@DeleteMapping("{cId}")
public  ResponseEntity<String> deleteCustomerAccount(@PathVariable("cId") int cId)
{
	this.customerService.deleteCustomerAccount(cId);
	return new ResponseEntity<String>("Your Account deleted successfully",HttpStatus.OK);
}

}
