package com.ergo.DataBankBackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.ergo.DataBankBackend.model.Customer;


public interface CustomerRepository extends JpaRepository<Customer,Long> {

}
