package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.LocationDto;
import com.julian.bella.api.dto.RouteDto;
import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.domain.Location;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.Route;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.OrderRepo;

@Component
public class RouteMapper implements GenericMapper<Route, RouteDto> {

	LocationMapper locationMapper;
	VehicleMapper vehicleMapper;
	OrderRepo orderRepo;

	public RouteMapper(LocationMapper locationMapper, VehicleMapper vehicleMapper, OrderRepo orderRepo) {
		this.locationMapper = locationMapper;
		this.vehicleMapper = vehicleMapper;
		this.orderRepo = orderRepo;
	}

	@Override
	public RouteDto sourceToDto(Route source) {
		if(source == null) {
			return null;
		}
		LocationDto from = locationMapper.sourceToDto(source.from);
		LocationDto to = locationMapper.sourceToDto(source.destination);
		VehicleDto vehicleDto = vehicleMapper.sourceToDto(source.getVehicle());
		RouteDto dto = new RouteDto();
		dto.setDestination(to)
			.setFrom(from)
			.setId(source.getId())
			.setOrderId(source.order.getId())
			.setVehicle(vehicleDto);
		return dto;
	}

	@Override
	public Route dtoToNewSource(RouteDto dto) {
		if(dto == null) {
			return null;
		}
		Order order = orderRepo.findById(dto.getOrderId()).orElseThrow(ResourceNotFoundException::new);
		Location from = locationMapper.dtoToNewSource(dto.getFrom());
		Location to = locationMapper.dtoToNewSource(dto.getDestination());
		Route route = new Route(order, from, to);
		route.setVehicle(vehicleMapper.dtoToNewSource(dto.getVehicle()));
		return route;
	}

	@Override
	public Route dtoToUpdatedSource(Route source, RouteDto dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		source.setVehicle(vehicleMapper.dtoToUpdatedSource(source.getVehicle(), dto.getVehicle()));
		return source;
	}

}
