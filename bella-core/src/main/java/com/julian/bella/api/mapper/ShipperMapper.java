package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.domain.Shipper;
import com.julian.bella.domain.User;

@Component
public class ShipperMapper implements GenericMapper<Shipper, ShipperDto> {

	UserMapper userMapper;

	@Autowired
	public ShipperMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public ShipperDto sourceToDto(Shipper source) {
		if (source == null) {
			return null;
		}
		UserDto userDto = userMapper.sourceToDto(source.getUser());

		ShipperDto dto = new ShipperDto();
		
		dto.setId(source.getId())
			.setActive(source.isActive())
			.setPesel(source.peselEncrypted)
			.setFirstName(source.getFirstName())
			.setLastName(source.getLastName())
			.setUserDto(userDto);
		return dto;
	}
	
	@Override
	public Shipper dtoToNewSource(ShipperDto dto) {
		if(dto == null) {
			return null;
		}
		User user = userMapper.dtoToNewSource(dto.getUserDto());

		Shipper source = new Shipper(dto.getPesel()); //sourceClass.getDeclaredConstructor(String.class).newInstance(dto.getPesel());
		
		source.setActive(dto.isActive());
		source.setFirstName(dto.getFirstName());
		source.setLastName(dto.getLastName());
		source.setUser(user);
		return source;
	}
	
	@Override
	public Shipper dtoToUpdatedSource(Shipper source, ShipperDto dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		User user = userMapper.dtoToUpdatedSource(source.getUser(), dto.getUserDto());
		
		source.setActive(dto.isActive());
		source.setFirstName(dto.getFirstName());
		source.setLastName(dto.getLastName());
		source.setUser(user);
		return source;
	}
}