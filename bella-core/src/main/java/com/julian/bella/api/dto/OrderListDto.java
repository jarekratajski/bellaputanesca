package com.julian.bella.api.dto;

import java.util.List;

public class OrderListDto extends GenericListDto<OrderDto> {

	public OrderListDto(List<OrderDto> list) {
		super(list);
	}
}
