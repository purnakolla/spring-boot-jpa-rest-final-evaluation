package com.springboot.evaluation.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.springboot.evaluation.domain.Customer;
import com.springboot.evaluation.repository.CustomerRepo;

@Service
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	private CustomerRepo customerRepo;

	@Override
	public List<Customer> retrieveCustomers() {
		List<Customer> customer = customerRepo.findAll();
		return customer;
	}

	@Override
	public Optional<Customer> getCustomer(Long customerId) {

		Optional<Customer> optCst = customerRepo.findById(customerId);
		return optCst;

	}

	@Override
	public Customer saveCustomer(Customer customer) {
		customerRepo.save(customer);
		return null;
	}

	@Override
	public Customer deleteCustomer(Long customerId) {
		customerRepo.deleteById(customerId);
		return null;

	}
	
	@Override
	public Customer updateCustomer(Long customerId, Customer customer) {
		customerRepo.save(customer);
		return null;
	}
}
