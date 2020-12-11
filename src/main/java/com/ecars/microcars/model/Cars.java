package com.ecars.microcars.model;

import javax.persistence.*;

@Entity
public class Cars {

    //ID
    @Id
    @GeneratedValue
    private int id;

    //DATA ON CARS
    private String brand;
    private String model;

    public Cars() {
    }

    public Cars(String brand, String model) {
    }

    public Cars(int id, String brand, String model) {
        this.id = id;
        this.brand = brand;
        this.model = model;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "Car{" +
                "id=" + id +
                ", brand='" + brand + '\'' +
                ", model='" + model + '\'' +
                '}';
    }
}