package com.sample.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.sample.Exception.CustomerNotFoundException;
import com.sample.Exception.CustomerNotFoundExceptionById;
import com.sample.Exception.ResourceNotFoundException;
import com.sample.entity.Customer;
import com.sample.repositary.CustomerRepository;
import com.sample.service.CustomerService;
@Service
public class CustomerServiceImpl implements CustomerService 
{
	@Autowired
     private CustomerRepository customerRepository;
     
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	
	@Override
	public Customer registerCustomer(Customer customer) {
		
		return this.customerRepository.save(customer);
	}

	
	@Override
	public Customer loginCustomer(Customer customer)throws CustomerNotFoundException {
        
	  return this.customerRepository.findByuserNameAndPassword(customer.userName,customer.password).orElseThrow(()->new ResourceNotFoundException("Invalid username or password"));
				
	}


	@Override
	public Customer updateCustomer(Customer customer,int cId) {
		
		Customer existingCustomer=this.customerRepository.findById(cId).orElseThrow(()->new CustomerNotFoundExceptionById("Customer","cId",cId));
		existingCustomer.setfName(customer.getfName());
		existingCustomer.setlName(customer.getlName());
		existingCustomer.setPhoneNo(customer.getPhoneNo());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setUserName(customer.getUserName());
		existingCustomer.setPassword(customer.getPassword());
		this.customerRepository.save(existingCustomer);
		return existingCustomer;
	}
	
	@Override
	public Customer updateCustomerByUserName(Customer customer,String userName) {
		
		Customer existingCustomer=this.customerRepository.findByUserName(userName).orElseThrow(()->new CustomerNotFoundException("Customer username not found....."));
		existingCustomer.setfName(customer.getfName());
		existingCustomer.setlName(customer.getlName());
		existingCustomer.setPhoneNo(customer.getPhoneNo());
		existingCustomer.setAddress(customer.getAddress());
		existingCustomer.setUserName(customer.getUserName());
		existingCustomer.setPassword(customer.getPassword());
		this.customerRepository.save(existingCustomer);
		return existingCustomer;
	}

	@Override
	public void deleteCustomerAccount(int cId) {
		this.customerRepository.findById(cId).orElseThrow(()->new CustomerNotFoundExceptionById("Customer","cId",cId));
		this.customerRepository.deleteById(cId);
		
	}


	@Override
	public Customer getCustomerById(int cId) {
		
		return this.customerRepository.findById(cId).get();
	}


	@Override
	public Customer getCustomerByUserName(String userName) {
		return this.customerRepository.findByUserName(userName).get();
	}


}
