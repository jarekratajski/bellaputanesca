package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.Client;

public interface ClientRepo extends JpaRepository<Client, Long>{

}
