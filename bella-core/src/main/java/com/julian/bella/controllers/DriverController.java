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

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.DriverListDto;
import com.julian.bella.services.DriverService;


@RestController
@RequestMapping("/api/empl/drivers")
public class DriverController {

	private final DriverService driverService;

	@Autowired
	public DriverController(DriverService service) {
		this.driverService = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public DriverListDto getAllClients() {
		return driverService.getAllDrivers();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public DriverDto getClient(@PathVariable Long id) {
		return driverService.getDriver(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public DriverDto createNewDriver(@RequestBody DriverDto driverDto) {
		return driverService.createNewDriver(driverDto);
	}

	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public DriverDto updateDriver(@PathVariable Long id, @RequestBody DriverDto driverDto) {
		return driverService.updateDriver(id, driverDto);
	}
}
