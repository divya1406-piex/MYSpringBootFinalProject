package com.sample;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertNotEquals;
import static org.junit.Assert.assertSame;
import static org.junit.Assert.assertThat;
import static org.junit.jupiter.api.Assertions.assertNotNull;

import java.util.List;

import org.junit.Assert;
import org.junit.Ignore;
import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Order;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestMethodOrder;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.sample.entity.Customer;
import com.sample.entity.Product;
import com.sample.repositary.CustomerRepository;
import com.sample.repositary.ProductRepository;

@SpringBootTest
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
class MySpringBootFinalProjectApplicationTests {

@Autowired
CustomerRepository customerRepository;

@Autowired
ProductRepository productRepository;

//adding customer
@Test
@Order(1)
public void testCreate()
{

Customer customer=new Customer();
customer.setfName("Dinesh");
customer.setlName("D");
customer.setPhoneNo("9876553210");
customer.setAddress("chennai");
customer.setUserName("dinesh12@gmail.com");
customer.setPassword("123456");
customerRepository.save(customer);
assertNotNull(customerRepository.findById(5).get());
}

//updating product price
@Test
@Order(2)
public void testUpdate()
{
Product product=this.productRepository.findById(1).get();
product.setPrice(300.00);
this.productRepository.save(product);
assertNotEquals(500.00,this.productRepository.findById(1).get().getPrice());
}

//deleting customer
@Test
@Order(3)
public void testDelete()
{
customerRepository.deleteById(69);
assertFalse(customerRepository.existsById(69));
}

//checking Product price
@Test
@Order(4)
public void testSingleProduct()
{
Product product=this.productRepository.findById(1).get();
Assert.assertEquals(300,product.getPrice(),0.0f);
}

//deleting product
@Test
@Order(5)
public void testDeleteProduct()
{
productRepository.deleteById(68);
assertFalse(productRepository.existsById(68));
}
}