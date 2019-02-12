package com.example.demo.controller;

import javax.annotation.Resource;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	
	@Resource
	CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<?> findCustomer(@RequestParam(required=false) Long customerId) {
		return customerService.findCustomer(customerId);
	}
	
	@PostMapping("customer")
	public ResponseEntity<?> insertCustomer (@RequestBody Customer customer) {
		return customerService.insertCustomer(customer);
	}
	
	@PutMapping("customer")
	public ResponseEntity<?> updateCustomer(@RequestBody Customer customer){
		return customerService.updateCustomer(customer);
	}
	
	@DeleteMapping("customer")
	public ResponseEntity<?> deleteCustomer(@RequestParam(required=true) Long customerId){
		return customerService.deleteCustomer(customerId);
	}
}
