package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Location;

public interface LocationRepo extends JpaRepository<Location, Long>{

}
