package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.UserDto;
import com.julian.bella.api.dto.UserListDto;
import com.julian.bella.domain.User;

@Service
public interface UserService {
	
	UserListDto getAllUser();

	UserDto getUser(Long id);

	UserDto saveUser(User user);

	UserDto createNewUser(UserDto userDto);

	UserDto updateUser(Long id, UserDto userDto);

	UserDto getUserByLogin(String login);
}
