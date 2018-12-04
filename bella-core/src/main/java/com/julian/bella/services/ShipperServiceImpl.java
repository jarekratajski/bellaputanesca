package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.api.dto.ShipperListDto;
import com.julian.bella.api.mapper.ShipperMapper;
import com.julian.bella.domain.Shipper;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.ShipperRepo;

@Service
public class ShipperServiceImpl implements ShipperService {

	ShipperRepo repo;
	ShipperMapper mapper;
	UserService userService;

	@Autowired
	public ShipperServiceImpl(ShipperRepo repo, ShipperMapper mapper, UserService userService) {
		this.repo = repo;
		this.mapper = mapper;
		this.userService = userService;
	}

	@Override
	public ShipperListDto getAllShippers() {
		return new ShipperListDto(
				repo.findAll().stream().map(mapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public ShipperDto getShipper(Long id) {
		return (ShipperDto) mapper.sourceToDto(repo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}

	@Override
	public ShipperDto saveShipper(Shipper shipper) {
		shipper = repo.save(shipper);
		return (ShipperDto) mapper.sourceToDto(shipper);
	}

	@Override
	public ShipperDto createNewShipper(ShipperDto dto) {
		dto.setUserDto(userService.getUserByLogin(dto.getUserDto().getLogin()));
		Shipper s = (Shipper) mapper.dtoToNewSource(dto);
		return this.saveShipper(s);
	}

	@Override
	public ShipperDto updateShipper(Long id, ShipperDto dto) {
		Shipper oldS = repo.findById(id).orElseThrow(ResourceNotFoundException::new);
		Shipper newS = (Shipper) mapper.dtoToUpdatedSource(oldS, dto);
		return this.saveShipper(newS);
	}
}
