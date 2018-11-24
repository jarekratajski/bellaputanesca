package com.julian.bella.api.mapper;


import java.util.stream.Collectors;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.ClientListDto;
import com.julian.bella.api.dto.OrderDto;
import com.julian.bella.api.dto.OrderStatusHistoryListDto;
import com.julian.bella.api.dto.ParcelListDto;
import com.julian.bella.api.dto.RouteDto;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.Route;

@Component
public class OrderMapper implements GenericMapper<Order, OrderDto> {

	ClientMapper clientMapper;
	ParcelMapper parcelMapper;
	RouteMapper routeMapper;
	OrderStatusHistoryMapper orderStatusHistoryMapper;
	
	public OrderMapper(ClientMapper clientMapper, ParcelMapper parcelMapper, RouteMapper routeMapper,
			OrderStatusHistoryMapper orderStatusHistoryMapper) {
		this.clientMapper = clientMapper;
		this.parcelMapper = parcelMapper;
		this.routeMapper = routeMapper;
		this.orderStatusHistoryMapper = orderStatusHistoryMapper;
	}
	
	@Override
	public OrderDto sourceToDto(Order source) {
		if(source == null) {
			return null;
		}
		ClientListDto clientsDto = new ClientListDto(source.getClientsCopy().stream().map(clientMapper::sourceToDto)
				.collect(Collectors.toList()));
		
		ParcelListDto parcelsDto = new ParcelListDto(source.getParcelsCopy().stream().map(parcelMapper::sourceToDto)
				.collect(Collectors.toList()));
		
		RouteDto routeDto = routeMapper.sourceToDto(source.getRoute());
		
		OrderStatusHistoryListDto statusDto = new OrderStatusHistoryListDto(source.getStatusHistoryCopy().stream()
				.map(orderStatusHistoryMapper::sourceToDto)
				.collect(Collectors.toList()));
		
		OrderDto dto = new OrderDto();
		dto.setActualStatus(source.getActualStatus())
			.setClients(clientsDto)
			.setId(source.getId())
			.setNotes(source.getNotes())
			.setParcels(parcelsDto)
			.setRoute(routeDto)
			.setStatusHistory(statusDto);
		
		return dto;
	}

	@Override
	public Order dtoToNewSource(OrderDto dto) {
		if(dto == null) {
			return null;
		}
		Route route = routeMapper.dtoToNewSource(dto.getRoute());
		Order order = new Order();
		order.setNotes(dto.getNotes());
		order.setRoute(route);
		order.updateStatus(dto.getActualStatus());
		
		return order;
	}

	@Override
	public Order dtoToUpdatedSource(Order source, OrderDto dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		source.setNotes(dto.getNotes());
		source.setRoute(routeMapper.dtoToUpdatedSource(source.getRoute(), dto.getRoute()));
		source.updateStatus(dto.getActualStatus());
		return source;
	}

}
