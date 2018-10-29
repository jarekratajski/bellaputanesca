package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Parcel;

public interface ParcelRepo extends JpaRepository<Parcel, Long>{

}
