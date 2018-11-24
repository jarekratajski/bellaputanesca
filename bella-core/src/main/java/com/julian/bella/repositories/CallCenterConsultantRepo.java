package com.julian.bella.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.julian.bella.domain.CallCenterConsultant;

@Repository
public interface CallCenterConsultantRepo extends JpaRepository<CallCenterConsultant, Long> {

}
