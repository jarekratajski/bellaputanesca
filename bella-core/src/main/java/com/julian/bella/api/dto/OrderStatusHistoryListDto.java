package com.julian.bella.api.dto;

import java.util.List;

public class OrderStatusHistoryListDto extends GenericListDto<OrderStatusHistoryDto> {

	public OrderStatusHistoryListDto(List<OrderStatusHistoryDto> list) {
		super(list);
	}
}
