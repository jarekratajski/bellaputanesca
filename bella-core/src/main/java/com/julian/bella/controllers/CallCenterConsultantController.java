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

import com.julian.bella.api.dto.CallCenterConsultantDto;
import com.julian.bella.api.dto.CallCenterConsultantListDto;
import com.julian.bella.services.CallCenterConsultantService;
import com.julian.bella.services.UserService;


@RestController
@RequestMapping("/api/empl/ccconsultants")
public class CallCenterConsultantController {

	private final CallCenterConsultantService cccService;
	private final UserService userService;
	
	@Autowired
	public CallCenterConsultantController(CallCenterConsultantService service, UserService userService) {
		this.cccService = service;
		this.userService = userService;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public CallCenterConsultantListDto getAllCallCenterConsultants() {
		return cccService.getAllCallCenterConsultants();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public CallCenterConsultantDto getCallCenterConsultant(@PathVariable Long id) {
		return cccService.getCallCenterConsultant(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public CallCenterConsultantDto createNewCallCenterConsultant(@RequestBody CallCenterConsultantDto cccDto) {
		userService.createNewUser(cccDto.getUserDto());
		return cccService.createNewCallCenterConsultant(cccDto);
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public CallCenterConsultantDto updateDriver(@PathVariable Long id, @RequestBody CallCenterConsultantDto cccDto) {
		return cccService.updateCallCenterConsultant(id, cccDto);
	}

}
