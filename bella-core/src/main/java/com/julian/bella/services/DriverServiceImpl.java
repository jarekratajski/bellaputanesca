package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.DriverListDto;
import com.julian.bella.api.dto.UserDto;
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
		return driverMapper.sourceToDto(driverRepo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public DriverDto saveDriver(Driver driver) {
		driver = driverRepo.save(driver);
		return driverMapper.sourceToDto(driver);
	}

	@Override
	public DriverDto createNewDriver(DriverDto driverDto) {
		Driver drv = driverMapper.dtoToNewSource(driverDto);
		return this.saveDriver(drv);
	}

	@Override
	public DriverDto createNewDriverForUser(Long userId, DriverDto driverDto) {
		UserDto userDto = userService.getUser(userId);
		driverDto.setUserDto(userDto);
		Driver drv = driverMapper.dtoToNewSource(driverDto);
		return this.saveDriver(drv);
	}

	@Override
	public DriverDto updateDriver(Long id, DriverDto driverDto) {
		Driver oldDrv = driverRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		Driver newDrv = driverMapper.dtoToUpdatedSource(oldDrv, driverDto);
		return this.saveDriver(newDrv);
	}

}
