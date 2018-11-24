package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.RouteDto;
import com.julian.bella.api.dto.RouteListDto;
import com.julian.bella.domain.Route;

@Service
public interface RouteService {

	RouteListDto getAllRoutes();
	
	RouteDto getRoute(Long id);
	
	RouteDto saveRoute(Route route);
	
	RouteDto createNewRoute(RouteDto dto);
	
	RouteDto updateRoute(Long id, RouteDto dto);
	
	void deleteRouteById(Long id);
}
