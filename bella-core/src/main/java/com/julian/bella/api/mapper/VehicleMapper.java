package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.VehicleDto;
import com.julian.bella.domain.Driver;
import com.julian.bella.domain.Vehicle;

@Component
public class VehicleMapper implements GenericMapper<Vehicle, VehicleDto> {

	DriverMapper driverMapper;

	@Autowired
	public VehicleMapper(DriverMapper driverMapper) {
		this.driverMapper = driverMapper;
	}

	@Override
	public VehicleDto sourceToDto(Vehicle source) {
		if(source == null) {
			return null;
		}
		DriverDto drvDto = driverMapper.sourceToDto(source.getDriver());
		VehicleDto dto = new VehicleDto();

		dto.setCapacityKg(source.getCapacity())
			.setDriverDto(drvDto)
			.setMileageKm(source.getMileage())
			.setPurchaseDate(source.getPurchaseDate())
			.setVin(source.getVin());
		
		return dto;
	}

	@Override
	public Vehicle dtoToNewSource(VehicleDto dto) {
		if(dto == null) {
			return null;
		}
		Driver drv = driverMapper.dtoToNewSource(dto.getDriverDto());
		Vehicle v = new Vehicle(dto.getVin());
		v.setDriver(drv);
		v.setCapacity(dto.getCapacityKg());
		v.setPurchaseDate(dto.getPurchaseDate());
		return v;
	}

	@Override
	public Vehicle dtoToUpdatedSource(Vehicle source, VehicleDto dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		Driver drv = driverMapper.dtoToUpdatedSource(source.getDriver(), dto.getDriverDto());
		source.setDriver(drv);
		source.setCapacity(dto.getCapacityKg());
		source.setPurchaseDate(dto.getPurchaseDate());
		return source;
	}

}
