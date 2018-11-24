package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.OrderFinances;

@Repository
public interface OrderFinancesRepo extends JpaRepository<OrderFinances, Long>{

}
