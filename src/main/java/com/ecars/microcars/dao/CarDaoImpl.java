package com.ecars.microcars.dao;

import com.ecars.microcars.model.Car;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class CarDaoImpl implements CarDao {

    public static List<Car> cars = new ArrayList<>();

    static {
        cars.add(new Car(1, "Honda", "Jazz"));
        cars.add(new Car(2, "Volvo", "940"));
        cars.add(new Car(3, "Opel", "Corsa"));
    }

    @Override
    public List<Car> findAll() {
        return cars;
    }

    @Override
    public Car findById(int id) {
        for (Car car : cars) {
            if (car.getId() == id) {
                return car;
            }
        }
        return null;
    }

    @Override
    public Car save(Car car) {
        cars.add(car);
        return car;
    }

    @Override
    public Car deleteCar(int id){
        for (Car car : cars){
            if (car.getId() == id) {
                cars.remove(id);
            }
        }
        return null;
    }

    @Override
    public Car updateCar(Car car) {
        return car;
    }
}
