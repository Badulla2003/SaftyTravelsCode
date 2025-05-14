package com.booking.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.booking.model.Customer;
import com.booking.repository.CustomerRepository;

@Service
public class CustomerService {
	
	@Autowired
	CustomerRepository customerRep;

	public boolean saveCustomer(Customer customer) {
		System.out.println("CustomerService.saveCustomer()");
		Customer c=customerRep.save(customer);
		if(c!=null) {
			return true;
		}
		return false;
	}
	
	public boolean deleteCustomer(Integer customerId) {
		System.out.println("CustomerService.deleteCustomer()");
	    int i=customerRep.deleteCustomer(customerId);
	    if(i>0) {
	    	return true;
	    }
		return false;
	}
	
	public List<Customer> getAllSavedPassangers(){
		List<Customer> list=customerRep.findAll();
		if(!list.isEmpty()) {
			return list;
		}
		return null;
	}
}
