package com.sample.service;

import com.sample.Exception.CustomerNotFoundException;
import com.sample.entity.Customer;

public interface CustomerService {
	
Customer registerCustomer(Customer customer);
Customer loginCustomer(Customer customer)throws CustomerNotFoundException;
Customer getCustomerById(int cId);
Customer getCustomerByUserName(String userName);
Customer updateCustomer(Customer customer,int cId);
Customer updateCustomerByUserName(Customer customer,String userName);
void deleteCustomerAccount(int cId);
}