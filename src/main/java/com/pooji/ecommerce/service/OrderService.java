package com.pooji.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooji.ecommerce.entities.Customer;
import com.pooji.ecommerce.entities.Order;
import com.pooji.ecommerce.entities.OrderItem;
import com.pooji.ecommerce.repos.OrderItemRepository;
import com.pooji.ecommerce.repos.OrderRepository;

import jakarta.transaction.Transactional;

@Service
public class OrderService {

	@Autowired
	private OrderRepository orderRepository;

	@Autowired
	private OrderItemRepository orderItemRepository;


	@Transactional
	public Order placeOrder(Customer customer, List<OrderItem> orderItems) {
		Order order = new Order();
		order.setCustomer(customer);
		Order savedOrder = orderRepository.save(order);

		orderItems.forEach(item -> {
		    item.setOrder(savedOrder);
		    savedOrder.getItems().add(item); // Adding item to order's list
		    orderItemRepository.save(item);
		});

		return savedOrder;
	}

	public Optional<Order> getOrderById(Long id) {
		return orderRepository.findById(id);
	}

	public List<Order> getOrdersByCustomerId(Long customerId) {
		return orderRepository.findByCustomerId(customerId);
	}

	public boolean cancelOrder(Long id) {
		if (orderRepository.existsById(id)) {
			orderRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
