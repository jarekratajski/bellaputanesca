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

import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.api.dto.ParcelListDto;
import com.julian.bella.services.ParcelService;


@RestController
@RequestMapping("/api/parcels")
public class ParcelController {

	private final ParcelService service;
	
	@Autowired
	public ParcelController(ParcelService service) {
		this.service = service;
	}
	
	@GetMapping
	@ResponseStatus(code = HttpStatus.OK)
	public ParcelListDto getAllParcels() {
		return service.getAllParcels();
	}
	
	@GetMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.OK)
	public ParcelDto getParcel(@PathVariable Long id) {
		return service.getParcel(id);
	}
	
	@PostMapping
	@ResponseStatus(code = HttpStatus.CREATED)
	public ParcelDto createNewParcel(@RequestBody ParcelDto dto) {
		return service.createNewParcel(dto);
	}
	
	@PutMapping("/id={id}")
	@ResponseStatus(code = HttpStatus.CREATED)
	public ParcelDto updateParcel(@PathVariable Long id, @RequestBody ParcelDto dto) {
		return service.updateParcel(id, dto);
	}
}
