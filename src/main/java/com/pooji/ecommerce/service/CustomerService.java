package com.pooji.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooji.ecommerce.entities.Customer;
import com.pooji.ecommerce.repos.CustomerRepository;

@Service
public class CustomerService {

	@Autowired
	private CustomerRepository customerRepository;

	public Customer saveCustomer(Customer customer) {
        return customerRepository.save(customer);
    }

    public List<Customer> getAllCustomers() {
        return customerRepository.findAll();
    }

    public Optional<Customer> getCustomerById(Long id) {
        return customerRepository.findById(id);
    }

}
