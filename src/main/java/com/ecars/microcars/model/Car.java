package com.ecars.microcars.model;

import javax.persistence.*;
import javax.xml.crypto.Data;
import java.text.SimpleDateFormat;
import java.util.Date;

@Entity // Comprend que le nom de la table sera automatiquement car et les colonnes id, brand & model, etc
public class Car {

/*
    private static SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm'Z'");
*/

    //ID
    @Id
    @GeneratedValue
    private int id;

    //TIMESTAMP
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdAt;

    @Temporal(TemporalType.TIMESTAMP)
    private Date modifiedAt;

    //DATA ON CARS
    private String brand;
    private String model;

    public Car() {
    }

    public Car(String brand, String model) {
    }

    public Car(int id, String brand, String model, Date createdAt, Date modifiedAt) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.createdAt = createdAt;
        this.modifiedAt = modifiedAt;
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
                ", modifiedAt='" + model + '\''+
                '}';
    }
}
