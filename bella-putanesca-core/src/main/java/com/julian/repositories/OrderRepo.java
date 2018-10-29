package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Order;

public interface OrderRepo extends JpaRepository<Order, Long>{

}
