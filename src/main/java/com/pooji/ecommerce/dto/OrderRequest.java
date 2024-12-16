package com.pooji.ecommerce.dto;

import java.util.List;

import com.pooji.ecommerce.entities.Customer;
import com.pooji.ecommerce.entities.OrderItem;

public class OrderRequest {
	    private Customer customer;
	    private List<OrderItem> items;
		public Customer getCustomer() {
			return customer;
		}
		public void setCustomer(Customer customer) {
			this.customer = customer;
		}
		public List<OrderItem> getItems() {
			return items;
		}
		public void setItems(List<OrderItem> items) {
			this.items = items;
		}
	}


