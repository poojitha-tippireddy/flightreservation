package com.pooji.ecommerce.repos;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooji.ecommerce.entities.Order;

public interface OrderRepository extends JpaRepository<Order, Long> {

    List<Order> findByCustomerId(Long customerId);
}