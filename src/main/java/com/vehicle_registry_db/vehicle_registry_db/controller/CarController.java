package com.vehicle_registry_db.vehicle_registry_db.controller;

import com.vehicle_registry_db.vehicle_registry_db.controller.dtos.CarRequest;
import com.vehicle_registry_db.vehicle_registry_db.controller.dtos.CarResponse;
import com.vehicle_registry_db.vehicle_registry_db.controller.mapper.CarMapper;
import com.vehicle_registry_db.vehicle_registry_db.domain.Car;
import com.vehicle_registry_db.vehicle_registry_db.service.CarService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.NoSuchElementException;

@RestController
@Tag(name = "Coches", description = "Gestión de coches")
public class CarController {

    @Autowired
    private CarService carService;

    @Autowired
    private CarMapper carMapper;

    @Operation(summary = "Obtener un coche por ID", description = "Devuelve los detalles de un coche dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche encontrado"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado")
    })
    @GetMapping("/cars/{id}")
    public ResponseEntity<?> getCar(@PathVariable int id) {
        try {
            CarResponse response = carMapper.toResponse(carService.getCarById(id));
            return ResponseEntity.ok(response);
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Añadir un coche", description = "Añade un coche nuevo al registro")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche añadido correctamente"),
            @ApiResponse(responseCode = "500", description = "Error al añadir el coche")
    })
    @PostMapping("/cars")
    public ResponseEntity<?> addCar(@RequestBody CarRequest request) {
        try {
            Car carModel = carMapper.toModel(request);
            return ResponseEntity.ok(carService.saveCar(carModel));
        } catch (IllegalArgumentException e) {
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        } catch (Exception e) {

            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
    }

    @Operation(summary = "Eliminar un coche", description = "Elimina un coche del registro dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche eliminado correctamente"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado")
    })
    @DeleteMapping("/cars/{id}")
    public ResponseEntity<?> deleteCar(@PathVariable int id) {
        try {
            carService.deleteById(id);
            return ResponseEntity.status(HttpStatus.OK).build();
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }

    @Operation(summary = "Actualizar un coche", description = "Actualiza los detalles de un coche dado su ID")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "Coche actualizado correctamente"),
            @ApiResponse(responseCode = "404", description = "Coche no encontrado")
    })
    @PutMapping("/cars/{id}")
    public ResponseEntity<?> updateCar (@PathVariable int id, @RequestBody CarRequest request){
        try {
            Car carToModel = carMapper.toModel(request);
            return ResponseEntity.ok(carService.updateById(id, carToModel));
        } catch (NoSuchElementException e) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        }
    }
}
