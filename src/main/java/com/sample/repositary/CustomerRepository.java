package com.sample.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Customer;
import java.util.Optional;
@Repository
public interface CustomerRepository extends JpaRepository<Customer,Integer> {
	Optional<Customer> findByuserNameAndPassword(String userName,String password);
	Optional<Customer> findByUserName(String userName);

}
