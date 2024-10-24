package com.vehicle_registry_db.vehicle_registry_db.service;
import com.vehicle_registry_db.vehicle_registry_db.domain.Car;
import com.vehicle_registry_db.vehicle_registry_db.entity.CarEntity;

public interface CarService {
    Car getCarById(int id);

    void deleteById(int id);

    Car saveCar(Car carRequest);

    Car updateById(Integer id, Car carRequest);
}
