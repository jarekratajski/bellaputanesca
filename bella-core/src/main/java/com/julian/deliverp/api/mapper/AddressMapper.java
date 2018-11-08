package com.julian.deliverp.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.deliverp.api.dto.AddressDto;
import com.julian.deliverp.domain.Address;

@Component
public class AddressMapper implements GenericMapper<Address, AddressDto>{

	@Override
	public AddressDto sourceToDto(Address address) {
		if(address == null) {
			return null;
		}
 		AddressDto dto = new AddressDto();
		dto.setCity(address.city)
			.setHouseNumberEtc(address.houseNumberEtc)
			.setPostalCode(address.postalCode)
			.setStreet(address.street);
		return dto;
	}

	@Override
	public Address dtoToNewSource(AddressDto dto) {
		if(dto == null) {
			return null;
		}
		return new Address(dto.getCity(), dto.getStreet(), dto.getHouseNumberEtc(), dto.getPostalCode());
	}

	@Override
	public Address dtoToUpdatedSource(Address address, AddressDto dto) {
		return dtoToNewSource(dto);
	}
}
