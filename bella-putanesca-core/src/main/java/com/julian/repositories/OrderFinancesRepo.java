package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.OrderFinances;

public interface OrderFinancesRepo extends JpaRepository<OrderFinances, Long>{

}
