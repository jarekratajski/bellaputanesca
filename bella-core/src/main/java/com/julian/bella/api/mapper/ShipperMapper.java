package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.domain.Shipper;

@Component
public class ShipperMapper implements GenericMapper<Shipper, ShipperDto> {

	EmployeeBaseMapper<Shipper, ShipperDto> baseMapper;
	
	@Autowired
	public ShipperMapper(EmployeeBaseMapper<Shipper, ShipperDto> baseMapper) {
		this.baseMapper = baseMapper;
		baseMapper.setSourceClassType(Shipper.class);
		baseMapper.setDtoClassType(ShipperDto.class);
	}
	
	@Override
	public ShipperDto sourceToDto(Shipper source) {		
		return baseMapper.sourceToDto(source);
	}

	@Override
	public Shipper dtoToNewSource(ShipperDto dto) {
		return baseMapper.dtoToNewSource(dto);
	}

	@Override
	public Shipper dtoToUpdatedSource(Shipper source, ShipperDto dto) {
		return baseMapper.dtoToUpdatedSource(source, dto);
	}
}