package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Operation;

public interface OperationRepo extends JpaRepository<Operation, Long>{

}
