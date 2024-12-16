package com.pooji.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooji.ecommerce.entities.Customer;

public interface CustomerRepository extends JpaRepository<Customer, Long> {

}
