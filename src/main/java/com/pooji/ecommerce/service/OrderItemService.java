package com.pooji.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooji.ecommerce.entities.OrderItem;
import com.pooji.ecommerce.repos.OrderItemRepository;

@Service
public class OrderItemService {

    @Autowired
    private OrderItemRepository orderItemRepository;

    public OrderItem saveOrderItem(OrderItem orderItem) {
        return orderItemRepository.save(orderItem);
    }

    public List<OrderItem> getAllOrderItems() {
        return orderItemRepository.findAll();
    }

    public Optional<OrderItem> getOrderItemById(Long id) {
        return orderItemRepository.findById(id);
    }

    public boolean deleteOrderItem(Long id) {
        if (orderItemRepository.existsById(id)) {
            orderItemRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
