package com.sample.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Cart;
import com.sample.entity.Customer;
@Repository
public interface CartRepository extends JpaRepository<Cart, Integer> {
Cart findBypIdAndCustomer(int pId,Customer customer);
}
