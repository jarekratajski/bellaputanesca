package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ClientDto;
import com.julian.bella.api.dto.OrderDto;
import com.julian.bella.api.dto.OrderFinancesDto;
import com.julian.bella.api.dto.OrderListDto;
import com.julian.bella.api.dto.OrderStatusHistoryListDto;
import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.api.mapper.OrderFinancesMapper;
import com.julian.bella.api.mapper.OrderMapper;
import com.julian.bella.api.mapper.OrderStatusHistoryMapper;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.OrderStatus;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.OrderRepo;

@Service
public class OrderServiceImpl implements OrderService {

	OrderRepo repo;
	OrderMapper mapper;
	OrderStatusHistoryMapper statusHistoryMapper;
	OrderFinancesMapper financesMapper;
	
	public OrderServiceImpl(OrderRepo repo, OrderMapper mapper, OrderStatusHistoryMapper statusHistoryMapper,
			OrderFinancesMapper financesMapper) {
		this.repo = repo;
		this.mapper = mapper;
		this.statusHistoryMapper = statusHistoryMapper;
		this.financesMapper = financesMapper;
	}
	
	@Override
	public OrderDto getOrder(Long id) {
		return mapper.sourceToDto(repo.findById(id).orElseThrow(ResourceNotFoundException::new));                      
	}
	
	@Override
	public OrderListDto getAllOrders() {
		return new OrderListDto(repo.findAll().stream().map(mapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public OrderListDto getAllOrdersForClient(String nip) {
		return new OrderListDto(repo.findByClientsNip(nip).stream().map(mapper::sourceToDto)
				.collect(Collectors.toList()));
	}
		
	@Override
	public OrderStatusHistoryListDto getStatusHistory(Long orderId) {
		return new OrderStatusHistoryListDto(
				repo.findById(orderId).orElseThrow(ResourceNotFoundException::new)
				.getStatusHistoryCopy().stream().map(statusHistoryMapper::sourceToDto).collect(Collectors.toList())
				);
	}
	
	@Override
	public OrderFinancesDto getFinances(Long orderId) {
		return financesMapper.sourceToDto(repo.findById(orderId).orElseThrow(ResourceNotFoundException::new)
				.getFinances());
	}
	
	@Override
	public Order createOrder(Order order) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void editOrder(Order order, Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void cancelOrder(Long id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void recalculateFinances() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void updateStatus(OrderStatus status) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addParcel(ParcelDto parcel) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void addClient(ClientDto client) {
		// TODO Auto-generated method stub
		
	}
	
}
