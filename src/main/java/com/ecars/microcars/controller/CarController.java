package com.ecars.microcars.controller;

import com.ecars.microcars.model.Car;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CarController {

    //cars/{id}
    @GetMapping(value = "cars/{id}")
    public Car showCar(@PathVariable int id) {
        Car car = new Car(id, "Honda", "Jazz");
        return car;
    }
}
