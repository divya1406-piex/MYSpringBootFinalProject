package com.sample.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Product;
@Repository
public interface ProductRepository extends JpaRepository<Product,Integer> {
Optional<Product> findBypName(String pName);//ask doubt
}
