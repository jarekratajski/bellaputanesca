package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.OrderStatusHistory;

public interface OrderStatusHistoryRepo extends JpaRepository<OrderStatusHistory, Long>{

}
