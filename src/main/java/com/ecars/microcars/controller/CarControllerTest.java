package com.ecars.microcars.controller;

import com.ecars.microcars.model.Cars;
import com.ecars.microcars.repository.CarRepository;
import org.junit.jupiter.api.*;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test //Test getAll()
    @Order(1)
    public void stage1_AllCars() throws Exception {
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":1,\"brand\":\"Renault\",\"model\":\"Clio\"},{\"id\":2,\"brand\":\"Volvo\",\"model\":\"940\"}]");
    }

    @Test
    @Order(2)
    public void stage2_GetById() throws Exception {
        String cars = restTemplate.getForObject("/cars/2", String.class);
        assertEquals(cars, "{\"id\":2,\"brand\":\"Volvo\",\"model\":\"940\"}");
    }

    @Test
    @Order(3)
    public void stage3_PostANewCar() throws Exception {
        Cars newCar = new Cars( 3, "Tesla", "S");
        restTemplate.postForObject("/cars", newCar, String.class);
    }

    @Test
    @Order(4)
    public void stage4_UpdateCar() throws Exception {
        Cars cars = new Cars(2, "Audi", "A2");
        restTemplate.put("/cars/2", cars, String.class);
        String carTwo = restTemplate.getForObject("/cars/2", String.class);
        assertEquals(carTwo, "{\"id\":2,\"brand\":\"Audi\",\"model\":\"A2\"}");

    }

    @Test
    @Order(5)
    public void stage5_DeleteCar() throws Exception {
        restTemplate.delete("/cars/1", String.class);
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":2,\"brand\":\"Audi\",\"model\":\"A2\"}]");
    }
}