package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.AddressDto;
import com.julian.bella.api.dto.LocationDto;
import com.julian.bella.domain.Address;
import com.julian.bella.domain.Location;

@Component
public class LocationMapper implements GenericMapper<Location, LocationDto> {

	AddressMapper addressMapper;
	
	public LocationMapper(AddressMapper addressMapper) {
		this.addressMapper = addressMapper;
	}
	
	@Override
	public LocationDto sourceToDto(Location source) {
		if(source == null) {
			return null;
		}
		AddressDto a = addressMapper.sourceToDto(source.address);
		LocationDto dto = new LocationDto();
		dto.setAddress(a).setLongitude(source.longitude).setLatitude(source.latitude);
		return dto;
	}

	@Override
	public Location dtoToNewSource(LocationDto dto) {
		if(dto == null) {
			return null;
		}
		Address address = addressMapper.dtoToNewSource(dto.getAddress());
		Location location = new Location(address, dto.getLongitude(), dto.getLatitude());
		return location;
	}

	@Override
	public Location dtoToUpdatedSource(Location source, LocationDto dto) {
		return dtoToNewSource(dto);
	}

}
