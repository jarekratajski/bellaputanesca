package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Vehicle;

public interface VehicleRepo extends JpaRepository<Vehicle, Long>{

}
