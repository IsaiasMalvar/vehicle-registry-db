package com.vehicle_registry_db.vehicle_registry_db.service.converter;

import com.vehicle_registry_db.vehicle_registry_db.domain.Car;
import com.vehicle_registry_db.vehicle_registry_db.entity.CarEntity;
import org.springframework.stereotype.Component;

@Component
public class CarConverter {

    public Car toCar (CarEntity entity){
        Car car = new Car();
        car.setBrand(entity.getBrand());
        car.setModel(entity.getModel());
        car.setYear(entity.getYear());
        car.setColour(entity.getColour());
        car.setMileage(entity.getMileage());
        car.setDescription(entity.getDescription());
        car.setFuelType(entity.getFuelType());

        return car;
    }

    public CarEntity toEntity (Car car){
        CarEntity carEntity = new CarEntity();
        carEntity.setBrand(car.getBrand());
        carEntity.setModel(car.getModel());
        carEntity.setYear(car.getYear());
        carEntity.setColour(car.getColour());
        carEntity.setMileage(car.getMileage());
        carEntity.setDescription(car.getDescription());
        carEntity.setFuelType(car.getFuelType());

        return carEntity;
    }
}
