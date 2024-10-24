package com.vehicle_registry_db.vehicle_registry_db.controller.mapper;
import com.vehicle_registry_db.vehicle_registry_db.controller.dtos.CarRequest;
import com.vehicle_registry_db.vehicle_registry_db.controller.dtos.CarResponse;
import com.vehicle_registry_db.vehicle_registry_db.domain.Car;
import org.springframework.stereotype.Component;

@Component
public class CarMapper {

    public CarResponse toResponse (Car carRequest){
        CarResponse car = new CarResponse();
        car.setBrand(carRequest.getBrand());
        car.setModel(carRequest.getModel());
        car.setYear(carRequest.getYear());
        car.setColour(carRequest.getColour());
        car.setMileage(carRequest.getMileage());
        car.setDescription(carRequest.getDescription());
        car.setFuelType(carRequest.getFuelType());

        return car;
    }

    public Car toModel (CarRequest car){
        Car carModel = new Car();
        carModel.setBrand(car.getBrand());
        carModel.setModel(car.getModel());
        carModel.setYear(car.getYear());
        carModel.setColour(car.getColour());
        carModel.setMileage(car.getMileage());
        carModel.setDescription(car.getDescription());
        carModel.setFuelType(car.getFuelType());

        return carModel;
    }
}

