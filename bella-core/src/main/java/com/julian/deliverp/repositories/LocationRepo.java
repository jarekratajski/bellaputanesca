package com.julian.deliverp.repositories;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.julian.deliverp.domain.Location;

@Repository
public interface LocationRepo extends CrudRepository<Location, Long>{

}
