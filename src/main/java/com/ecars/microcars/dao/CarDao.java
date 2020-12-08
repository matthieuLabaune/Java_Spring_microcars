package com.ecars.microcars.dao;

import com.ecars.microcars.model.Car;

import java.util.List;

public interface CarDao {

    public List<Car> findAll();

    public Car findById(int id);

    public Car save(Car car);
}