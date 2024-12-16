package com.pooji.ecommerce.repos;

import org.springframework.data.jpa.repository.JpaRepository;

import com.pooji.ecommerce.entities.Product;

public interface ProductRepository extends JpaRepository<Product, Long> {

}
