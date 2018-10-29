package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
