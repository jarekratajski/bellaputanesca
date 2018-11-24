package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Driver;

@Repository
public interface DriverRepo extends JpaRepository<Driver, Long> {

}
