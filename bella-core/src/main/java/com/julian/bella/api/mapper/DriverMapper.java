package com.julian.bella.api.mapper;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.DriverDto;
import com.julian.bella.api.dto.UserDto;
import com.julian.bella.domain.Driver;
import com.julian.bella.domain.User;

@Component
public class DriverMapper implements GenericMapper<Driver, DriverDto> {

	UserMapper userMapper;

	@Autowired
	public DriverMapper(UserMapper userMapper) {
		this.userMapper = userMapper;
	}

	@Override
	public DriverDto sourceToDto(Driver source) {
		if (source == null) {
			return null;
		}
		UserDto userDto = userMapper.sourceToDto(source.getUser());

		DriverDto dto = new DriverDto();
		
		dto.setId(source.getId())
			.setActive(source.isActive())
			.setPesel(source.peselEncrypted)
			.setFirstName(source.getFirstName())
			.setLastName(source.getLastName())
			.setUserDto(userDto);
		return dto;
	}
	
	@Override
	public Driver dtoToNewSource(DriverDto dto) {
		if(dto == null) {
			return null;
		}
		User user = userMapper.dtoToNewSource(dto.getUserDto());

		Driver source = new Driver(dto.getPesel()); //sourceClass.getDeclaredConstructor(String.class).newInstance(dto.getPesel());
		
		source.setActive(dto.isActive());
		source.setFirstName(dto.getFirstName());
		source.setLastName(dto.getLastName());
		source.setUser(user);
		return source;
	}
	
	@Override
	public Driver dtoToUpdatedSource(Driver source, DriverDto dto) {
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