package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.OrderFinances;

@Repository
public interface OrderFinancesRepo extends JpaRepository<OrderFinances, Long>{

}
