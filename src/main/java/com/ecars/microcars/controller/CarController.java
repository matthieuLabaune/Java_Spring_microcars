package com.ecars.microcars.controller;

import com.ecars.microcars.dao.CarDao;
import com.ecars.microcars.model.Car;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.sql.rowset.CachedRowSet;
import java.util.List;

@Api(tags = "CarController.java : Controller pour API REST (CRUD sur les voitures)")
@RestController
public class CarController {

    @Autowired //Instanciation automatique
    private CarDao carDao;

    //INDEX => /cars
    @ApiOperation(value = "Récupère la liste de toutes les voitures")
    @GetMapping(value = "cars") //GET Mapping pour l'uri pour la liste des voitures
    public List<Car> listCars() {
        return carDao.findAll();
    }

    //SHOW BY ID => /cars/{id}
    @ApiOperation(value = "Récupère une voiture grâce à son ID")
    @GetMapping(value = "cars/{id}") //GET Mapping pour l'uri pour retourner une voiture par l'id
    public Car showCar(@PathVariable int id) {// Va chercher le paramètre id dans l'url et le passe à notre méthode
        return carDao.findById(id);
    }

    @ApiOperation(value = "Ajoute une voiture grâce à la liste")
    //STORE /cars
    @RequestMapping(value = "/cars/store", method = RequestMethod.POST)
    public ResponseEntity<Object> createCar(@RequestBody Car car) {
        carDao.save(car);
        return new ResponseEntity<>("Car is created successfully", HttpStatus.CREATED);
    }

    @ApiOperation(value = "Mise à jour d'une voiture grâce à son ID")
    @PutMapping(value = "/cars/{id}/")
    public ResponseEntity<Object> updateCar(@PathVariable("id") int id, @RequestBody Car car) {
        Car currentCar = carDao.findById(id);
        currentCar.setBrand(car.getBrand());
        currentCar.setModel(car.getModel());
        carDao.updateCar(currentCar);
        return new ResponseEntity<>("Car is updated successsfully", HttpStatus.OK);
    }

    //DELETE
    @ApiOperation(value = "Supprime une voiture grâce à son ID")
    @RequestMapping(value = "/cars/{id}", method = RequestMethod.DELETE)
    public ResponseEntity<Object> delete(@PathVariable("id") int id) {
        carDao.deleteCar(id);
        return new ResponseEntity<>("Car is deleted successfully", HttpStatus.OK);
    }
}
