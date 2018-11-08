package com.julian.deliverp.services;

import com.julian.deliverp.domain.Order;

public interface OrderService {

	public Order createOrder(Order order);
	
	public void editOrder(Order order, Long id);
	
	public void cancelOrder(Long id);
	
	public Order previewOrder(Long id);
	
}
