package com.julian.bella.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.api.dto.ShipperListDto;
import com.julian.bella.services.ShipperService;
import com.julian.bella.services.UserService;


@RestController
@RequestMapping("/api/empl/shippers")
public class ShipperController {

	private final ShipperService cccService;
	private final UserService userService;
	
	@Autowired
	public ShipperController(ShipperService service, UserService userService) {
		this.cccService = service;
		this.userService = userService;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ShipperListDto getAllShippers() {
		return cccService.getAllShippers();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ShipperDto getShipper(@PathVariable Long id) {
		return cccService.getShipper(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ShipperDto createNewShipper(@RequestBody ShipperDto cccDto) {
		userService.createNewUser(cccDto.getUserDto());
		return cccService.createNewShipper(cccDto);
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ShipperDto updateDriver(@PathVariable Long id, @RequestBody ShipperDto cccDto) {
		return cccService.updateShipper(id, cccDto);
	}

}
