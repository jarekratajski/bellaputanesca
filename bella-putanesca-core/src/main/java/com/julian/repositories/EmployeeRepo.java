package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Long>{

}
