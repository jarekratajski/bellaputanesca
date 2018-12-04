package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.DriverListDto;
import com.julian.bella.api.mapper.DriverMapper;
import com.julian.bella.domain.Driver;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.DriverRepo;

@Service
public class DriverServiceImpl implements DriverService {

	DriverRepo driverRepo;
	DriverMapper driverMapper;
	UserService userService;

	@Autowired
	public DriverServiceImpl(DriverRepo repo, DriverMapper mapper, UserService userService) {
		this.driverRepo = repo;
		this.driverMapper = mapper;
		this.userService = userService;
	}

	@Override
	public DriverListDto getAllDrivers() {
		return new DriverListDto(
				driverRepo.findAll().stream().map(driverMapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public DriverDto getDriver(Long id) {
		return (DriverDto) driverMapper.sourceToDto(driverRepo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public DriverDto saveDriver(Driver driver) {		
		driver = driverRepo.save(driver);
		return (DriverDto) driverMapper.sourceToDto(driver);
	}

	@Override
	public DriverDto createNewDriver(DriverDto driverDto) {
		driverDto.setUserDto(userService.getUserByLogin(driverDto.getUserDto().getLogin()));
		Driver drv = (Driver) driverMapper.dtoToNewSource(driverDto);
		return this.saveDriver(drv);
	}

	@Override
	public DriverDto updateDriver(Long id, DriverDto driverDto) {
		Driver oldDrv = driverRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		Driver newDrv = (Driver) driverMapper.dtoToUpdatedSource(oldDrv, driverDto);
		return this.saveDriver(newDrv);
	}
}
