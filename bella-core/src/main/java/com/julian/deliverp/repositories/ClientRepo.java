package com.julian.deliverp.repositories;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

	Optional<Client> findByNip(String nip);

	void deleteByNip(String nip);
}
