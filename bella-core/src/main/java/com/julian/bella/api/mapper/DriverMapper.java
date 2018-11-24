package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.domain.Driver;

@Component
public class DriverMapper implements GenericMapper<Driver, DriverDto> {

	EmployeeBaseMapper<Driver, DriverDto> baseMapper;
	
	@Autowired
	public DriverMapper(EmployeeBaseMapper<Driver, DriverDto> baseMapper) {
		this.baseMapper = baseMapper;
		baseMapper.setSourceClassType(Driver.class);
		baseMapper.setDtoClassType(DriverDto.class);
	}
	
	@Override
	public DriverDto sourceToDto(Driver source) {		
		return baseMapper.sourceToDto(source);
	}

	@Override
	public Driver dtoToNewSource(DriverDto dto) {
		return baseMapper.dtoToNewSource(dto);
	}

	@Override
	public Driver dtoToUpdatedSource(Driver source, DriverDto dto) {
		return baseMapper.dtoToUpdatedSource(source, dto);
	}

}