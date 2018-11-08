package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.deliverp.domain.Address;

public interface AddressRepo extends JpaRepository<Address, Long>{

}
