package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ShipperDto;
import com.julian.bella.api.dto.ShipperListDto;
import com.julian.bella.domain.Shipper;

@Service
public interface ShipperService {
	ShipperListDto getAllShippers();

	ShipperDto getShipper(Long id);

	ShipperDto saveShipper(Shipper shipper);

	ShipperDto createNewShipper(ShipperDto shipperDto);

	ShipperDto updateShipper(Long id, ShipperDto shipperDto);
}
