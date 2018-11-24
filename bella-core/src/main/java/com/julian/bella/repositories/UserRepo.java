package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

	boolean existsByLogin(String login);

}
