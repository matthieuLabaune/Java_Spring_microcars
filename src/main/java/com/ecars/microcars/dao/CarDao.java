package com.ecars.microcars.dao;

import com.ecars.microcars.model.Car;

import java.util.List;

public interface CarDao {

    //Contrats pour CarDao
    public List<Car> findAll();

    public Car findById(int id);

    public Car save(Car car);

    public Car updateCar(Car car);

    public Car deleteCar(int id);
}