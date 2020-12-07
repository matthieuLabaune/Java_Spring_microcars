package com.ecars.microcars.controller;

import com.ecars.microcars.dao.CarDao;
import com.ecars.microcars.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@RestController
public class CarController {

    @Autowired
    private CarDao carDao;

    //cars
    @GetMapping(value = "cars")
    public List<Car> listCars() {
        return carDao.findAll();
    }

    //cars/{id}
    @GetMapping(value = "cars/{id}")
    public Car showCar(@PathVariable int id) {
        Car car = new Car(id, "Honda", "Jazz");
        return car;
    }
}
