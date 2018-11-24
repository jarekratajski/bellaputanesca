package com.julian.bella.services;

import org.springframework.stereotype.Service;

import com.julian.bella.api.dto.ParcelDto;
import com.julian.bella.api.dto.ParcelListDto;
import com.julian.bella.domain.Parcel;

@Service
public interface ParcelService {

	ParcelListDto getAllParcels();

	ParcelDto getParcel(Long id);

	ParcelDto saveParcel(Parcel parcel);

	ParcelDto createNewParcel(ParcelDto parcelDto);

	ParcelDto updateParcel(Long parcelId, ParcelDto parcelDto);

	void deleteParcel(Long parcelId);

}
