package com.pooji.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;
import com.pooji.ecommerce.entities.OrderItem;

public interface OrderItemRepository extends JpaRepository<OrderItem, Long> {

}
