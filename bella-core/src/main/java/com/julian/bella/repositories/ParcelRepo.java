package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Parcel;

@Repository
public interface ParcelRepo extends JpaRepository<Parcel, Long> {

}
