package com.julian.bella.api.dto;

import java.time.LocalDateTime;

import com.julian.bella.domain.OrderStatus;

public class OrderStatusHistoryDto {
	private Long id;
	private OrderStatus status;
	private LocalDateTime dateTime;

	public Long getId() {
		return id;
	}

	public OrderStatusHistoryDto setId(Long id) {
		this.id = id;
		return this;
	}

	public OrderStatus getStatus() {
		return status;
	}

	public OrderStatusHistoryDto setStatus(OrderStatus status) {
		this.status = status;
		return this;
	}

	public LocalDateTime getDateTime() {
		return dateTime;
	}

	public OrderStatusHistoryDto setDateTime(LocalDateTime dateTime) {
		this.dateTime = dateTime;
		return this;
	}

}
