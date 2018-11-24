package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.OrderStatusHistoryDto;
import com.julian.bella.domain.OrderStatusHistory;

@Component
public class OrderStatusHistoryMapper implements GenericMapper<OrderStatusHistory, OrderStatusHistoryDto> {

	@Override
	public OrderStatusHistoryDto sourceToDto(OrderStatusHistory source) {
		OrderStatusHistoryDto dto = new OrderStatusHistoryDto();
		dto.setDateTime(source.dateTime).setId(source.getId()).setStatus(source.status);
		return dto;
	}

	/*
	 * not able create or update OrderFinances class by any user. It is only in use for Order class.
	 */
	@Override
	public OrderStatusHistory dtoToNewSource(OrderStatusHistoryDto dto) {
		return null;
	}

	@Override
	public OrderStatusHistory dtoToUpdatedSource(OrderStatusHistory source, OrderStatusHistoryDto dto) {
		return null;
	}

}
