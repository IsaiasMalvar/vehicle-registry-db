package com.vehicle_registry_db.vehicle_registry_db.controller.dtos;

import lombok.Data;

@Data
public class CarResponse {
    private int id;

    private String brand;

    private String model;

    private int mileage;

    private double price;

    private int year;

    private String description;

    private String colour;

    private String fuelType;

    private int numDoors;
}
