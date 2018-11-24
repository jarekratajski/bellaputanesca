package com.julian.bella.api.mapper;

import org.springframework.stereotype.Component;

import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.domain.Order;
import com.julian.bella.domain.Parcel;

@Component
public class ParcelMapper implements GenericMapper<Parcel, ParcelDto> {

	@Override
	public ParcelDto sourceToDto(Parcel source) {
		if(source == null) {
			return null;
		}
		ParcelDto dto = new ParcelDto();
		dto.setId(source.getId())
			.setType(source.type)
			.setSizeDm3(source.sizeDm3)
			.setWeightKg(source.weightKg)
			.setFragile(source.isFragile)
			.setDescription(source.getDescription());
		return dto;
	}

	@Override
	public Parcel dtoToNewSource(ParcelDto dto) {
		if(dto == null) {
			return null;
		}
		Order order = new Order();
		Parcel parcel = new Parcel(dto.getType(),  dto.getWeightKg(), dto.getSizeDm3(), dto.isFragile(), order);
		parcel.setDescription(dto.getDescription());
		return parcel;
	}

	@Override
	public Parcel dtoToUpdatedSource(Parcel source, ParcelDto dto) {
		if(dto == null) {
			return null;
		}
		if(source == null) {
			return dtoToNewSource(dto);
		}
		source.setDescription(dto.getDescription());
		return source;
	}

}
