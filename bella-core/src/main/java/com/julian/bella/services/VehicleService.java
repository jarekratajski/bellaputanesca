package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.api.dto.VehicleListDto;
import com.julian.bella.domain.Vehicle;

@Service
public interface VehicleService {

	VehicleListDto getAllVehicles();
	
	VehicleDto getVehicle(String vin);
	
	VehicleDto saveVehicle(Vehicle vehicle);
	
	VehicleDto createNewVehicle(VehicleDto dto);
	
	VehicleDto updateVehicle(String vin, VehicleDto dto);
	
	void deleteVehicleById(String vin);
}
