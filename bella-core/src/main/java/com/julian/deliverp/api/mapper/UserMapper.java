package com.julian.deliverp.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.deliverp.api.dto.UserDto;
import com.julian.deliverp.domain.User;

@Component
public class UserMapper implements GenericMapper<User, UserDto> {

	@Override
	public UserDto sourceToDto(User source) {
		if(source == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setLogin(source.getLogin());
		return dto;
	}

	@Override
	public User dtoToNewSource(UserDto dto) {
		if(dto == null) {
			return null;
		}
		User user = new User();
		user.setLogin(dto.getLogin());
		return user;
	
	}

	@Override
	public User dtoToUpdatedSource(User source, UserDto dto) {
		if(source == null) {
			return dtoToNewSource(dto);
		}
		if(dto == null) {
			return null;
		}
		source.setLogin(dto.getLogin());
		return source;
	}

}
