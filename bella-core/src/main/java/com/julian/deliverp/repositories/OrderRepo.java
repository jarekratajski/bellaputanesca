package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

}
