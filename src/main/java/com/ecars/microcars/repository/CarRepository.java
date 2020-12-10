package com.ecars.microcars.repository;

import com.ecars.microcars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

     List<Car> findAll();

     Car findById(int id);

     Car save(Car car);

     Car deleteById(int id);
}