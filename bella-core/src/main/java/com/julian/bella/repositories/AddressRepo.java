package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Address;

@Repository
public interface AddressRepo extends JpaRepository<Address, Long>{

}
