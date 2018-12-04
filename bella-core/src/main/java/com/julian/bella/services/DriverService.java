package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.DriverListDto;
import com.julian.bella.domain.Driver;

@Service
public interface DriverService {
	
	DriverListDto getAllDrivers();

	DriverDto getDriver(Long id);

	DriverDto saveDriver(Driver driver);

	DriverDto createNewDriver(DriverDto driverDto);

	DriverDto updateDriver(Long id, DriverDto driverDto);
}
