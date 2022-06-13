package com.sample.repositary;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Payment;
@Repository
public interface PaymentRepository extends JpaRepository<Payment, Integer> {

}
