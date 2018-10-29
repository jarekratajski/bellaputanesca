package com.julian.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.julian.domain.User;

public interface UserRepo extends JpaRepository<User, Long>{

}
