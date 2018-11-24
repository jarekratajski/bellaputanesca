package com.julian.bella.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.Location;

@Repository
public interface LocationRepo extends CrudRepository<Location, Long>{

}
