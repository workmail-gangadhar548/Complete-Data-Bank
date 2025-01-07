package com.ergo.DataBankBackend.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.ergo.DataBankBackend.exception.ResourceNotFoundException;
import com.ergo.DataBankBackend.model.Customer;
import com.ergo.DataBankBackend.repository.CustomerRepository;
import com.ergo.DataBankBackend.service.CustomerService;

@Service
public class CustomerServiceImpl implements CustomerService{

	private CustomerRepository customerRepository;
	
	public CustomerServiceImpl(CustomerRepository customerRepository) {
		super();
		this.customerRepository = customerRepository;
	}

	@Override
	public Customer saveCustomer(Customer customer) {
		// TODO Auto-generated method stub
		return customerRepository.save(customer);
	}

	@Override
	public List<Customer> getAllCustomer() {
		// TODO Auto-generated method stub
		return customerRepository.findAll();
	}

	@Override
	public Customer getCustomerById(Long id) {
//		// TODO Auto-generated method stub
//		Optional<Customer> customer = customerRepository.findById(id);
//		if (customer.isPresent()) {
//			return customer.get();
//		} else {
//			throw new ResourceNotFoundException("Customer", "Id", customer);
//		}

		
		//This is lambda Expression to do the same work 
		return customerRepository.findById(id).orElseThrow(() -> 
					new ResourceNotFoundException("Customer", "Id", id));
	}

	@Override
	public Customer updateCustomer(Customer customer, long id) {
		// TODO Auto-generated method stub
		
		//we need to check whether customer with given id exist in database or not
		
		Customer existingCustomer = customerRepository.findById(id).orElseThrow(()-> 
					new ResourceNotFoundException("Customer", "Id", id));
		
		existingCustomer.setFirstName(customer.getFirstName());
		existingCustomer.setLastName(customer.getLastName());
		existingCustomer.setEmail(customer.getEmail());
		// save existing customer to database
		customerRepository.save(existingCustomer);
		return existingCustomer;
		
		
	}

	@Override
	public void deleteCustomer(long id) {
		// TODO Auto-generated method stub
		//check whether a customer exist in database or not
		
		customerRepository.findById(id).orElseThrow(()-> 
					new ResourceNotFoundException("Customer", "Id", id));
		
		customerRepository.deleteById(id);
	}

}
