package com.julian.bella.services;

import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.api.dto.ParcelListDto;
import com.julian.bella.api.mapper.ParcelMapper;
import com.julian.bella.domain.Parcel;
import com.julian.bella.exceptions.ResourceNotFoundException;
import com.julian.bella.repositories.ParcelRepo;

@Service
public class ParcelServiceImpl implements ParcelService {

	ParcelRepo repo;
	ParcelMapper mapper;
	
	@Autowired
	public ParcelServiceImpl(ParcelRepo repo, ParcelMapper mapper) {
		this.repo = repo;
		this.mapper = mapper;
	}
	
	@Override
	public ParcelListDto getAllParcels() {
		return new ParcelListDto(repo.findAll().stream().map(mapper::sourceToDto).collect(Collectors.toList()));
	}

	@Override
	public ParcelDto getParcel(Long id) {
		return mapper.sourceToDto(repo.findById(id).orElseThrow(ResourceNotFoundException::new));
	}
	
	@Override
	public ParcelDto saveParcel(Parcel parcel) {
		parcel = repo.save(parcel);
		return mapper.sourceToDto(parcel);
	}

	@Override
	public ParcelDto createNewParcel(ParcelDto parcelDto) {
		Parcel parcel = mapper.dtoToNewSource(parcelDto);
		return this.saveParcel(parcel);
	}

	@Override
	public ParcelDto updateParcel(Long parcelId, ParcelDto parcelDto) {
		Parcel oldParcel = repo.findById(parcelId).orElseThrow(ResourceNotFoundException::new);
		Parcel newParcel = mapper.dtoToUpdatedSource(oldParcel, parcelDto);
		return this.saveParcel(newParcel);
	}

	@Override
	public void deleteParcel(Long parcelId) {
		repo.deleteById(parcelId);
	}
}
