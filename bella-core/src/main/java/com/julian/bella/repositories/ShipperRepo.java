package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Shipper;

@Repository
public interface ShipperRepo extends JpaRepository<Shipper, Long> {

}
