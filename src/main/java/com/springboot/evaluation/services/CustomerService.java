package com.springboot.evaluation.services;

import java.util.List;
import java.util.Optional;

import com.springboot.evaluation.domain.Customer;

public interface CustomerService {

	List<Customer> retrieveCustomers();

	Optional<Customer> getCustomer(Long customerId);

	Customer saveCustomer(Customer customer);

	Customer updateCustomer(Long customerId, Customer customer);

	Customer deleteCustomer(Long customerId);
}
