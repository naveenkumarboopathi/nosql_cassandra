package com.example.demo.service;

import org.springframework.http.ResponseEntity;

import com.example.demo.entity.Customer;

public interface CustomerService {

	ResponseEntity<?> findCustomer(Long customerId);

	ResponseEntity<?> insertCustomer(Customer customer);

	ResponseEntity<?> updateCustomer(Customer customer);

	ResponseEntity<?> deleteCustomer(Long customerId);

}
