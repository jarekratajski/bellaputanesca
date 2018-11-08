package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.deliverp.domain.Route;

public interface RouteRepo extends JpaRepository<Route, Long> {

}
