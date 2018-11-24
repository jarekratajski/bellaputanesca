package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Vehicle;

@Repository
public interface VehicleRepo extends JpaRepository<Vehicle, String>{


}
