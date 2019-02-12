package com.example.demo.service.impl;

import java.util.List;
import java.util.Optional;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import com.example.demo.entity.Customer;
import com.example.demo.repository.CustomerRepository;
import com.example.demo.service.CustomerService;

@Component
public class CustomerServiceImpl implements CustomerService{

	CustomerRepository customerRepository;

	public CustomerServiceImpl(CustomerRepository customerRepository) {
		this.customerRepository = customerRepository;
	}

	@Override
	public ResponseEntity<?> findCustomer(Long customerId) {
		if(null != customerId) {
			Optional<Customer> customerOptional = customerRepository.findById(customerId);
			if(customerOptional.isPresent())
				return new ResponseEntity<>(customerOptional.get(), HttpStatus.OK);
			else
				return new ResponseEntity<>("Record Not Found",HttpStatus.BAD_REQUEST);
		}
		else {
			List<Customer> customerList = customerRepository.findAll();
			return new ResponseEntity<>(customerList,HttpStatus.OK);
		}
	}

	@Override
	public ResponseEntity<?> insertCustomer(Customer customer) {
		customer.setId(System.currentTimeMillis());
		customerRepository.save(customer);
		return new ResponseEntity<>("Record Save Successfully",HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateCustomer(Customer customer) {
		Optional<Customer> customerOptional = customerRepository.findById(customer.getId());
		if(customerOptional.isPresent()) {
			Customer customerDetail = customerOptional.get();
			customerDetail.setFirstName(customer.getFirstName());
			customerDetail.setLastName(customer.getLastName());
			customerRepository.save(customer);
			return new ResponseEntity<>("Record Save Successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Record Not Found",HttpStatus.BAD_REQUEST);
	}

	@Override
	public ResponseEntity<?> deleteCustomer(Long customerId) {
		Optional<Customer> customerOptional = customerRepository.findById(customerId);
		if(customerOptional.isPresent()) {
			customerRepository.deleteById(customerId); // if soft delete needed use isActive or isDeleted Flag
			return new ResponseEntity<>("Record Deleted Successfully", HttpStatus.OK);
		}
		else
			return new ResponseEntity<>("Record Not Found",HttpStatus.BAD_REQUEST);
	}

}
