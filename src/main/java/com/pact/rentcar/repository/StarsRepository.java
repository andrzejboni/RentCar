package com.pact.rentcar.repository;

import com.pact.rentcar.model.Stars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface StarsRepository extends JpaRepository<Stars, Long> {

}
