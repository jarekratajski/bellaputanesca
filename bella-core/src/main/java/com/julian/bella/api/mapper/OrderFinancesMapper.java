package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.OrderFinancesDto;
import com.julian.bella.domain.OrderFinances;

@Component
public class OrderFinancesMapper implements GenericMapper<OrderFinances, OrderFinancesDto> {

	@Override
	public OrderFinancesDto sourceToDto(OrderFinances source) {
		OrderFinancesDto dto = new OrderFinancesDto();
		dto.setEstimatedExpense(source.getEstimatedExpense())
			.setEstimatedPrice(source.getEstimatedPrice())
			.setFinalExpense(source.getFinalExpense())
			.setFinalPrice(source.getFinalPrice())
			.setOrderId(source.order.getId());
		return dto;
	}

	/*
	 * not able create or update OrderFinances class by any user. It is only in use for Order class.
	 */
	@Override
	public OrderFinances dtoToNewSource(OrderFinancesDto dto) {
		return null;
	}

	@Override
	public OrderFinances dtoToUpdatedSource(OrderFinances source, OrderFinancesDto dto) {
		return null;
	}

}
