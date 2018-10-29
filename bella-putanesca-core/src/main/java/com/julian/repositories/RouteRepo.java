package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Route;

public interface RouteRepo extends JpaRepository<Route, Long>{

}
