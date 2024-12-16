package com.pooji.ecommerce.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.pooji.ecommerce.entities.Product;
import com.pooji.ecommerce.repos.ProductRepository;

@Service
public class ProductService {

	@Autowired
	private ProductRepository productRepository;

	public Product saveProduct(Product product) {
		return productRepository.save(product);
	}

	public List<Product> getAllProducts() {
		return productRepository.findAll();
	}

	public Optional<Product> getProductById(Long id) {
		return productRepository.findById(id);
	}

	public Optional<Product> updateProduct(Long id, Product updatedProduct) {
		return productRepository.findById(id).map(product -> {
			product.setName(updatedProduct.getName());
			product.setDescription(updatedProduct.getDescription());
			product.setPrice(updatedProduct.getPrice());
			return productRepository.save(product);
		});
	}

	public boolean deleteProduct(Long id) {
		if (productRepository.existsById(id)) {
			productRepository.deleteById(id);
			return true;
		}
		return false;
	}
}
