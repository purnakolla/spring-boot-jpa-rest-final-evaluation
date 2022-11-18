package com.springboot.evaluation.controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.springboot.evaluation.domain.Customer;
import com.springboot.evaluation.services.CustomerService;

@RestController
@RequestMapping("/api")
public class CustomerController {
	@Autowired
	private CustomerService customerService;

	@GetMapping("/customers")
	public ResponseEntity<List<Customer>> retrieveCustomers() {
		try {

			List<Customer> customers = customerService.retrieveCustomers();

			if (customers.isEmpty() || customers.size() == 0) {

				return new ResponseEntity<>(HttpStatus.NO_CONTENT);

			}

			return new ResponseEntity<>(customers, HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

	@GetMapping("/customers/{customerId}")

	public ResponseEntity<Customer> getCustomer(@PathVariable(name = "customerId") Long customerId) {
		Optional<Customer> customer = customerService.getCustomer(customerId);

		if (customer.isPresent()) {

			return new ResponseEntity<>(customer.get(), HttpStatus.OK);

		}

		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

	@PostMapping("/customers")
	public ResponseEntity<Customer> saveCustomer(Customer customer) {
		try {

			return new ResponseEntity<>(customerService.saveCustomer(customer), HttpStatus.CREATED);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/customers/{customerId}")
	public ResponseEntity<Customer> updateCustomer( @PathVariable("customerId")  Long customerId ,@RequestBody Customer customer) {

		try {

			return new ResponseEntity<>(customerService.updateCustomer(customerId, customer), HttpStatus.OK);

		} catch (Exception e) {

			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);

		}
	}

	@DeleteMapping("/customers/{customerId}")
	public ResponseEntity<Customer> deleteCustomer(@PathVariable(name = "customerId") long customerId) {
		try {

			return new ResponseEntity<>(customerService.deleteCustomer(customerId), HttpStatus.NO_CONTENT);

		} catch (Exception e) {

			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);

		}

	}

}
