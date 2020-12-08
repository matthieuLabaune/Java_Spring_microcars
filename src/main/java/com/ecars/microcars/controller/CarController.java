package com.ecars.microcars.controller;

import com.ecars.microcars.dao.CarDao;
import com.ecars.microcars.model.Car;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@RestController
public class CarController {

    @Autowired //Instanciation automatique
    private CarDao carDao;

    //cars
    @GetMapping(value = "cars") //GET Mapping pour l'uri pour la liste des voitures
    public List<Car> listCars() {
        return carDao.findAll();
    }

    //cars/{id}
    @GetMapping(value = "cars/{id}") //GET Mapping pour l'uri pour retourner une voiture par l'id
    public Car showCar(@PathVariable int id) {// Va chercher le paramètre id dans l'url et le passe à notre méthode

        return carDao.findById(id);
    }

    @PostMapping(value = "cars")
    public void storeCar(@RequestBody Car car) { // Aller chercher dans le body de la requête la voiture et le parser
        carDao.save(car);
    }
}
