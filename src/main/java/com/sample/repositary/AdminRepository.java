package com.sample.repositary;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sample.entity.Admin;
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {
Optional<Admin> findByUserNameAndPassword(String userName,String password);
}
