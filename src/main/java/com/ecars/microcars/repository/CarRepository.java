package com.ecars.microcars.repository;

import com.ecars.microcars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {

}