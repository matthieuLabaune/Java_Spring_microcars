package com.ecars.microcars.controller;

import com.ecars.microcars.repository.CarRepository;
import com.ecars.microcars.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Api(tags = "CarController.java : Controller pour API REST (CRUD sur les voitures)")
@RestController
public class CarController {

    @Autowired //Instanciation automatique
    private CarRepository carRepository;

    //INDEX => /cars
    @ApiOperation(value = "Récupère la liste de toutes les voitures")
    @GetMapping(value = "cars") //GET Mapping pour l'uri pour la liste des voitures
    public List<Car> listCars() {
        return carRepository.findAll();
    }

    //SHOW BY ID => /cars/{id}
    @ApiOperation(value = "Récupère une voiture grâce à son ID")
    @GetMapping(value = "cars/{id}") //GET Mapping pour l'uri pour retourner une voiture par l'id
    public Car showCar(@PathVariable int id) {// Va chercher le paramètre id dans l'url et le passe à notre méthode
        return carRepository.findById(id);
    }

    @ApiOperation(value = "Ajoute une voiture grâce à la liste")
    //STORE /cars
    @RequestMapping(value = "/cars/", method = RequestMethod.POST)
    public ResponseEntity<Object> createCar(@RequestBody Car car) {
        carRepository.save(car);
        return new ResponseEntity<>("Car is created successfully", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Mise à jour d'une voiture grâce à son ID")
    @PutMapping(value = "/cars/{id}")
    public ResponseEntity<Object> updateCar(@PathVariable("id") int id, @RequestBody Car car) {
        Car currentCar = carRepository.findById(id);
        currentCar.setBrand(car.getBrand());
        currentCar.setModel(car.getModel());
        carRepository.save(currentCar);
        return new ResponseEntity<>("Car is updated successsfully", HttpStatus.OK);
    }

    @ApiOperation(value = "Supprime une voiture grâce à son ID")
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        carRepository.deleteById(id);
        return new ResponseEntity<>("Car is deleted successfully", HttpStatus.OK);
    }
}