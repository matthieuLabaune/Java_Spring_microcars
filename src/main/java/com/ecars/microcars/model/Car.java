package com.ecars.microcars.model;

public class Car {
    private String brand;
    private String modele;

    public Car(String brand, String modele) {
        this.brand = brand;
        this.modele = modele;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModele() {
        return modele;
    }

    public void setModele(String modele) {
        this.modele = modele;
    }

    @Override
    public String toString() {
        return "Car{" +
                ", brand='" + brand + '\'' +
                ", modele='" + modele + '\'' +
                '}';
    }
}
