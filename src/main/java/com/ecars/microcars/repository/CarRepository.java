package com.ecars.microcars.repository;

import com.ecars.microcars.model.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    //Contrats pour CarDao
    public List<Car> findAll();

    public Car findById(int id);

    public Car save(Car car);


}