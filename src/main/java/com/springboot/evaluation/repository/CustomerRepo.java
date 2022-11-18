package com.springboot.evaluation.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.springboot.evaluation.domain.Customer;

@Repository
public interface CustomerRepo extends JpaRepository<Customer, Long>{

}
