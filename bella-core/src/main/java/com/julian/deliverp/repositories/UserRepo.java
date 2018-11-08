package com.julian.deliverp.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.User;

@Repository
public interface UserRepo extends JpaRepository<User, Long>{

}
