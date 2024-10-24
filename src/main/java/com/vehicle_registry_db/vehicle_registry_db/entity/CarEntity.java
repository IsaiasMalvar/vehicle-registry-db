package com.vehicle_registry_db.vehicle_registry_db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "car")
public class CarEntity {

    @Id
    @GeneratedValue

    private int id;

    private String brand;

    private String model;

    private int mileage;

    private double price;

    @Column(name = "\"year\"", nullable = false)

    private int year;

    private String description;

    private String colour;

    @JsonProperty("fuelType")
    @Column(name = "fuel_type")
    private String fuelType;

    private int numDoors;
}
