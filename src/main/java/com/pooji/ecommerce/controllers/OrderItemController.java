package com.pooji.ecommerce.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.pooji.ecommerce.entities.OrderItem;
import com.pooji.ecommerce.service.OrderItemService;

@RestController
@RequestMapping("/order_items")
public class OrderItemController {

    @Autowired
    private OrderItemService orderItemService;

    @PostMapping
    public OrderItem addOrderItem(@RequestBody OrderItem orderItem) {
        return orderItemService.saveOrderItem(orderItem);
    }

    @GetMapping
    public List<OrderItem> getAllOrderItems() {
        return orderItemService.getAllOrderItems();
    }

    @GetMapping("/{id}")
    public ResponseEntity<OrderItem> getOrderItemById(@PathVariable Long id) {
        return orderItemService.getOrderItemById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteOrderItem(@PathVariable Long id) {
        if (orderItemService.deleteOrderItem(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
}
