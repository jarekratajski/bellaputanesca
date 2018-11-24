package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.UserDto;
import com.julian.bella.api.dto.UserListDto;
import com.julian.bella.api.mapper.UserMapper;
import com.julian.bella.domain.User;
import com.julian.bella.exceptions.ResourceAlreadyExistException;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.UserRepo;

@Service
public class UserServiceImpl implements UserService {

	UserRepo userRepo;
	UserMapper userMapper;

	@Autowired
	public UserServiceImpl(UserRepo repo, UserMapper mapper) {
		this.userRepo = repo;
		this.userMapper = mapper;
	}

	@Override
	public UserListDto getAllUser() {
		return new UserListDto(
				userRepo.findAll().stream().map(userMapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public UserDto getUser(Long id) {
		return userMapper.sourceToDto(userRepo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public UserDto saveUser(User user) {
		user = userRepo.save(user);
		return userMapper.sourceToDto(user);
	}

	@Override
	public UserDto createNewUser(UserDto userDto) {
		if(userRepo.existsByLogin(userDto.getLogin())) {
			throw new ResourceAlreadyExistException("Login " + userDto.getLogin() + " already exist.");
		}
		User usr = userMapper.dtoToNewSource(userDto);
		return this.saveUser(usr);
	}

	@Override
	public UserDto updateUser(Long id, UserDto userDto) {
		User oldUser = userRepo.findById(id).orElseThrow(ResourceNotFoundException::new);
		User newUser = userMapper.dtoToUpdatedSource(oldUser, userDto);
		return this.saveUser(newUser);
	}
}
