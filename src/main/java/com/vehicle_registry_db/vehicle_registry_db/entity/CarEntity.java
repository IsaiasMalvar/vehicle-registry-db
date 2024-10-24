package com.vehicle_registry_db.vehicle_registry_db.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table (name = "car")
public class CarEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
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

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    @PrePersist
    protected void onCreate() {
        this.createdAt = LocalDateTime.now();
    }
}
