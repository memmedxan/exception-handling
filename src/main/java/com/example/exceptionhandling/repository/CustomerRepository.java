package com.example.exceptionhandling.repository;

import com.example.exceptionhandling.entity.Customer;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CustomerRepository extends JpaRepository<Customer,Long> {
}
