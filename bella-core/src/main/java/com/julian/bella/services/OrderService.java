package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ClientDto;
import com.julian.bella.api.dto.OrderDto;
import com.julian.bella.api.dto.OrderFinancesDto;
import com.julian.bella.api.dto.OrderListDto;
import com.julian.bella.api.dto.OrderStatusHistoryListDto;
import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.OrderStatus;

@Service
public interface OrderService {

	public OrderDto getOrder(Long id);
	
	public OrderListDto getAllOrders();

	public OrderListDto getAllOrdersForClient(String nip);

	public OrderStatusHistoryListDto getStatusHistory(Long orderId);
	
	public OrderFinancesDto getFinances(Long orderId);
	
	public Order createOrder(Order order);

	public void editOrder(Order order, Long id);

	public void cancelOrder(Long id);

	public void recalculateFinances();

	public void updateStatus(OrderStatus status);

	public void addParcel(ParcelDto parcel);

	public void addClient(ClientDto client);

}
