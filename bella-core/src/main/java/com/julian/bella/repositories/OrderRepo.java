package com.julian.bella.repositories;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Order;

@Repository
public interface OrderRepo extends JpaRepository<Order, Long> {

	Collection<Order> findByClientsNip(String nip);
}
