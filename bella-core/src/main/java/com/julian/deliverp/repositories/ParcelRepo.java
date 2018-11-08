package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.deliverp.domain.Parcel;

public interface ParcelRepo extends JpaRepository<Parcel, Long> {

}
