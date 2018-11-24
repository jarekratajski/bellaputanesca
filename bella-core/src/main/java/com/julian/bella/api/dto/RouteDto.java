package com.julian.bella.api.dto;

public class RouteDto {

	private Long id;
	private Long orderId;
	private LocationDto from;
	private LocationDto destination;
	private VehicleDto vehicleDto;

	public Long getId() {
		return id;
	}

	public RouteDto setId(Long id) {
		this.id = id;
		return this;
	}

	public Long getOrderId() {
		return orderId;
	}

	public RouteDto setOrderId(Long orderId) {
		this.orderId = orderId;
		return this;
	}

	public LocationDto getFrom() {
		return from;
	}

	public RouteDto setFrom(LocationDto from) {
		this.from = from;
		return this;
	}

	public LocationDto getDestination() {
		return destination;
	}

	public RouteDto setDestination(LocationDto destination) {
		this.destination = destination;
		return this;
	}

	public VehicleDto getVehicle() {
		return vehicleDto;
	}

	public RouteDto setVehicle(VehicleDto vehicleDto) {
		this.vehicleDto = vehicleDto;
		return this;
	}

}
