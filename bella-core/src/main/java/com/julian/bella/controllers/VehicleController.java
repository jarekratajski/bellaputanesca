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

import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.api.dto.VehicleListDto;
import com.julian.bella.services.VehicleService;


@RestController
@RequestMapping("/api/vehicles")
public class VehicleController {

	private final VehicleService service;
	
	@Autowired
	public VehicleController(VehicleService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public VehicleListDto getAllVehicles() {
		return service.getAllVehicles();
	}
	
	@GetMapping("/vin={vin}")
	@ResponseStatus(code = HttpStatus.OK)
	public VehicleDto getVehicle(@PathVariable String vin) {
		return service.getVehicle(vin);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public VehicleDto createNewVehicle(@RequestBody VehicleDto dto) {
		return service.createNewVehicle(dto);
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public VehicleDto updateVehicle(@PathVariable String vin, @RequestBody VehicleDto dto) {
		return service.updateVehicle(vin, dto);
	}
}
