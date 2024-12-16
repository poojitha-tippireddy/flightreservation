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

import com.pooji.ecommerce.dto.OrderRequest;
import com.pooji.ecommerce.entities.Order;
import com.pooji.ecommerce.service.OrderService;

@RestController
@RequestMapping("/orders")
public class OrderController {

	@Autowired
	private OrderService orderService;
	
	

	@PostMapping
    public ResponseEntity<Order> placeOrder(@RequestBody OrderRequest orderRequest) {
        if (orderRequest.getCustomer() == null || orderRequest.getCustomer().getId() == null) {
            return ResponseEntity.badRequest().body(null);
        }

        
        return ResponseEntity.ok(orderService.placeOrder(orderRequest.getCustomer(), orderRequest.getItems()));
    }
	

    @GetMapping("/{id}")
    public ResponseEntity<Order> getOrderById(@PathVariable Long id) {
        return orderService.getOrderById(id)
                .map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @GetMapping("/customer/{customerId}")
    public List<Order> getOrdersByCustomerId(@PathVariable Long customerId) {
        return orderService.getOrdersByCustomerId(customerId);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> cancelOrder(@PathVariable Long id) {
        if (orderService.cancelOrder(id)) {
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }
    
    

    
    

}
