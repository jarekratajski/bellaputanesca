package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Long> {

}
