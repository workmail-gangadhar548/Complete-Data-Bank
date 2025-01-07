package com.ergo.DataBankBackend.service;

import java.util.List;

import com.ergo.DataBankBackend.model.Customer;

public interface CustomerService {
	Customer saveCustomer(Customer customer);
	List<Customer>getAllCustomer();
	Customer getCustomerById(Long id);
	Customer updateCustomer(Customer customer, long id);
	void deleteCustomer(long id );
}
