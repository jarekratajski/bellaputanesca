package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.UserDto;
import com.julian.bella.domain.User;

@Component
public class UserMapper implements GenericMapper<User, UserDto> {

	@Override
	public UserDto sourceToDto(User source) {
		if(source == null) {
			return null;
		}
		UserDto dto = new UserDto();
		dto.setLogin(source.getLogin()).setEmail(source.getEmail());
		return dto;
	}

	@Override
	public User dtoToNewSource(UserDto dto) {
		if(dto == null) {
			return null;
		}
		User user = new User();
		user.setLogin(dto.getLogin());
		user.setEmail(dto.getEmail());
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
		source.setEmail(dto.getEmail());
		return source;
	}

}
