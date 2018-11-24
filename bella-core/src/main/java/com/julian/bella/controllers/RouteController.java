package com.julian.bella.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.julian.bella.api.dto.RouteDto;
import com.julian.bella.api.dto.RouteListDto;
import com.julian.bella.services.RouteService;


@RestController
@RequestMapping("/api/routes")
public class RouteController {

	private final RouteService service;
	
	@Autowired
	public RouteController(RouteService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public RouteListDto getAllRoutes() {
		return service.getAllRoutes();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public RouteDto getVehicle(@PathVariable Long id) {
		return service.getRoute(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public RouteDto createNewRoute(@RequestBody RouteDto dto) {
		return service.createNewRoute(dto);
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public RouteDto updateVehicle(@PathVariable Long id, @RequestBody RouteDto dto) {
		return service.updateRoute(id, dto);
	}
}
