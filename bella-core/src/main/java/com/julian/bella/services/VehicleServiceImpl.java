package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.api.dto.VehicleListDto;
import com.julian.bella.api.mapper.VehicleMapper;
import com.julian.bella.domain.Vehicle;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.VehicleRepo;

@Service
public class VehicleServiceImpl implements VehicleService {

	VehicleRepo repo;
	VehicleMapper mapper;
	DriverService drvService;
	
	public VehicleServiceImpl(VehicleRepo repo, VehicleMapper mapper, DriverService drvService) {
		this.mapper = mapper;
		this.repo = repo;
		this.drvService = drvService;
	}
	
	@Override
	public VehicleListDto getAllVehicles() {
		return new VehicleListDto(repo.findAll().stream().map(mapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public VehicleDto getVehicle(String vin) {
		return mapper.sourceToDto(repo.findById(vin).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public VehicleDto saveVehicle(Vehicle vehicle) {
		Vehicle v = repo.save(vehicle);
		return mapper.sourceToDto(v);
	}

	@Override
	public VehicleDto createNewVehicle(VehicleDto dto) {
		System.out.println(dto.getDriverDto());
		dto.setDriverDto(drvService.getDriver(dto.getDriverDto().getId()));
		System.out.println(dto.getDriverDto());
		Vehicle v = mapper.dtoToNewSource(dto);
		return this.saveVehicle(v);
	}

	@Override
	public VehicleDto updateVehicle(String vin, VehicleDto dto) {
		Vehicle oldVehicle = repo.findById(vin).orElseThrow(ResourceNotFoundException::new);
		Vehicle newVehicle = mapper.dtoToUpdatedSource(oldVehicle, dto);
		return this.saveVehicle(newVehicle);		
	}

	@Override
	public void deleteVehicleById(String vin) {
		repo.deleteById(vin);
	}

}
