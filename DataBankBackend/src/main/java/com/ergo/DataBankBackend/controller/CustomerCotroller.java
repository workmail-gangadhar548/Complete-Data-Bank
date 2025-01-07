package com.ergo.DataBankBackend.controller;

import java.util.List;

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

import com.ergo.DataBankBackend.model.Customer;
import com.ergo.DataBankBackend.service.CustomerService;

@RestController
@RequestMapping("/api/customer")
public class CustomerCotroller {

	
	private CustomerService customerService;

	public CustomerCotroller(CustomerService customerService) {
		super();
		this.customerService = customerService;
	}
	
	@PostMapping
	public ResponseEntity<Customer> saveCustomer(@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.saveCustomer(customer),HttpStatus.CREATED);
	}
	
	//build get all customer REST API
	@GetMapping
	public List<Customer> getAllCustomer(){
		return customerService.getAllCustomer();
		
	}
	
	//build get Customer by id REST API
	//http:/localhost:8080/api/customer/1
	@GetMapping("{id}")
	public ResponseEntity<Customer> getCustomerById(@PathVariable("id") long customerid){
		return new ResponseEntity<Customer>(customerService.getCustomerById(customerid), HttpStatus.OK);
}
	
	//Build Update Customer REST API
	//http:/localhost:8080/api/customer/1
	@PutMapping("{id}")
	public ResponseEntity<Customer> updateCustomer(@PathVariable long id,
			@RequestBody Customer customer){
		return new ResponseEntity<Customer>(customerService.updateCustomer(customer, id),HttpStatus.OK);
		
	}
	//http:/localhost:8080/api/customer/1
	@DeleteMapping("{id}")
	public ResponseEntity<String> deleteCustomer(@PathVariable long id){//Try without @RequestBody Customer customer also 
		customerService.deleteCustomer(id);
//		boolean isDeleted = customerService.deleteCustomer(id);
//
//	    if (isDeleted) {
//	        return new ResponseEntity<>("Customer deleted successfully!", HttpStatus.OK);
//	    } else {
//	        return new ResponseEntity<>("Customer not found.", HttpStatus.NOT_FOUND);
//	    }
//		
		return new ResponseEntity<String>("Customer deleted succesfully!.", HttpStatus.OK);
		
	}
	
}
