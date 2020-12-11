package com.ecars.microcars.repository;

import com.ecars.microcars.model.Cars;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Cars, Integer> {

     List<Cars> findAll();

     Cars findById(int id);

     Cars save(Cars car);

     Cars deleteById(int id);
}