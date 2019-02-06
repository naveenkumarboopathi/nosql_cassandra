package com.example.demo.controller;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.entity.Customer;
import com.example.demo.service.CustomerService;

@RestController
public class CustomerController {

	
	@Resource
	CustomerService customerService;

	@GetMapping("/findAll")
	public List<Customer> findAll() {
		return customerService.findAll();
	}
	
	@GetMapping("/findById")
	public Customer findById(@RequestParam(required=true) Long customerId) {
		return customerService.findById(customerId);
	}
	
}
