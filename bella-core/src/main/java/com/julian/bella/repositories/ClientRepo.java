package com.julian.bella.repositories;

import java.util.Collection;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Client;

@Repository
public interface ClientRepo extends JpaRepository<Client, Long> {

	Optional<Client> findByNip(String nip);

	void deleteByNip(String nip);

	Collection<Client> findByOrdersId(Long id);
}
