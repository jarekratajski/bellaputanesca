package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Route;

@Repository
public interface RouteRepo extends JpaRepository<Route, Long> {

}
