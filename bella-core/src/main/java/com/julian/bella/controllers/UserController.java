package com.julian.bella.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.julian.bella.api.dto.UserDto;
import com.julian.bella.api.dto.UserListDto;
import com.julian.bella.services.UserService;

@RestController
@RequestMapping("api/users")
public class UserController {

	private UserService userService;
	
	@Autowired
	public UserController(UserService service) {
		this.userService = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public UserListDto getAllUsers() {
		return userService.getAllUser();
	}

	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto getUser(@PathVariable Long id) {
		return userService.getUser(id);
	}
	
	@GetMapping("/login={login}")
	@ResponseStatus(code = HttpStatus.OK)
	public UserDto getUserByLogin(@PathVariable String login) {
		return userService.getUserByLogin(login);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public UserDto createNewUser(@RequestBody UserDto userDto) {
		return userService.createNewUser(userDto);
	}
}
