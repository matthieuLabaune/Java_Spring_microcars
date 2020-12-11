package com.ecars.microcars.controller;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;

@ExtendWith(SpringExtension.class)
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class CarControllerTest {

    @Autowired
    private TestRestTemplate restTemplate;

    @Test //Test getAll()
    public void stage1_AllCars() throws Exception {
        String cars = restTemplate.getForObject("/cars", String.class);
        assertEquals(cars, "[{\"id\":1,\"brand\":\"Renault\",\"model\":\"Clio\"},{\"id\":2,\"brand\":\"Volvo\",\"model\":\"940\"}]");
    }

    @Test // Test findById()
    public void stage2_findById() throws Exception {
        String cars = restTemplate.getForObject("/cars/2", String.class);
        assertEquals(cars, "{\"id\":2,\"brand\":\"Volvo\",\"model\":\"940\"}");
    }
}

