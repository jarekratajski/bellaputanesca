package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.Employee;

@Repository
public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
