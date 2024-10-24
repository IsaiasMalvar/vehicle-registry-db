package com.vehicle_registry_db.vehicle_registry_db.service.impl;

import com.vehicle_registry_db.vehicle_registry_db.domain.Car;
import com.vehicle_registry_db.vehicle_registry_db.entity.CarEntity;
import com.vehicle_registry_db.vehicle_registry_db.repository.CarRepository;
import com.vehicle_registry_db.vehicle_registry_db.service.CarService;
import com.vehicle_registry_db.vehicle_registry_db.service.converter.CarConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CarServiceImpl implements CarService {

    @Autowired
    private CarRepository carRepository;

    @Autowired
    private CarConverter carConverter;

    @Override
    public Car getCarById(int id) {
        Optional<CarEntity> carEntity = carRepository.findById(id);
        if(carEntity.isPresent()){
            return carConverter.toCar(carEntity.get());
        }
        else {
            throw new NoSuchElementException();
        }
    }

    @Override
    public void deleteById(int id) {
        try {
            carRepository.deleteById(id);
        } catch (EmptyResultDataAccessException e) {
            throw new NoSuchElementException();
        }
    }

    @Override
    public CarEntity saveCar(Car carRequest) {
        try{
            CarEntity carEntity = carConverter.toEntity(carRequest);
            return carRepository.save(carEntity);
        } catch (IllegalArgumentException e){
            throw new IllegalArgumentException();
        }
        catch (DataIntegrityViolationException e) {
            throw new IllegalStateException();
        }catch (Exception e){
            throw new RuntimeException();
        }
    }

    @Override
    public CarEntity updateById(Integer id, Car carRequest) {

            CarEntity carEntity = carRepository.findById(id).orElseThrow(NoSuchElementException::new);
            CarEntity carModified = carConverter.toEntity(carRequest);
            carModified.setId(id);
            return carRepository.save(carModified);

    }
}
