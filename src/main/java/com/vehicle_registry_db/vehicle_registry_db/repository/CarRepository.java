package com.vehicle_registry_db.vehicle_registry_db.repository;
import com.vehicle_registry_db.vehicle_registry_db.entity.CarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CarRepository extends JpaRepository<CarEntity, Integer> {

}
