package com.julian.bella.api.dto;

import com.julian.bella.domain.OrderStatus;

public class OrderDto {

	private Long id;
	private OrderStatus actualStatus;
	private OrderStatusHistoryListDto statusHistory;
	private RouteDto route;
	private ParcelListDto parcels;
	private ClientListDto clients;
	private String notes;

	public Long getId() {
		return id;
	}

	public OrderDto setId(Long id) {
		this.id = id;
		return this;
	}

	public OrderStatus getActualStatus() {
		return actualStatus;
	}

	public OrderDto setActualStatus(OrderStatus actualStatus) {
		this.actualStatus = actualStatus;
		return this;
	}

	public OrderStatusHistoryListDto getStatusHistory() {
		return statusHistory;
	}

	public OrderDto setStatusHistory(OrderStatusHistoryListDto statusHistory) {
		this.statusHistory = statusHistory;
		return this;
	}

	public RouteDto getRoute() {
		return route;
	}

	public OrderDto setRoute(RouteDto route) {
		this.route = route;
		return this;
	}

	public ParcelListDto getParcels() {
		return parcels;
	}

	public OrderDto setParcels(ParcelListDto parcels) {
		this.parcels = parcels;
		return this;
	}

	public ClientListDto getClients() {
		return clients;
	}

	public OrderDto setClients(ClientListDto clients) {
		this.clients = clients;
		return this;
	}

	public String getNotes() {
		return notes;
	}

	public OrderDto setNotes(String notes) {
		this.notes = notes;
		return this;
	}

}
