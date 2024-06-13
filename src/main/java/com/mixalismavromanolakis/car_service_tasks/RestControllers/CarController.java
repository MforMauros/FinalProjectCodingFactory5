package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.CarDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Car;
import com.mixalismavromanolakis.car_service_tasks.Services.CarService;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIConverter;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIObjects.UICar;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Car Management System", description = "Operations pertaining to cars in Car Management System")
public class CarController {

    @Autowired
    CarService carService;

    @Autowired
    UIConverter UIConverter;

    public CarController(CarService carService) {
        this.carService = carService;
    }

    @Operation(summary = "Get a car by Id")
    @GetMapping("/car/{carId}")
    public ResponseEntity<CarDTO> getCarById(@PathVariable Integer carId) {

        Car carById = carService.getCarById(carId);
        if (carById != null) {
            CarDTO CarDTO = new CarDTO(carById);
            return new ResponseEntity<CarDTO>(CarDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No car with the id " + carId + " was found.");
        }
    }
    @Operation(summary = "View a list of available cars")
    @GetMapping(value = "/cars", produces = "application/json")
    public ResponseEntity<List<CarDTO>> getallCars() {

        List<CarDTO> allCars = carService.getallCars();
        return new ResponseEntity<List<CarDTO>>(allCars, HttpStatus.OK);
    }

    @Operation(summary = "Add a car")
    @PostMapping(value = "add-new-car", consumes = "application/json")
    public ResponseEntity<UICar> createCar(@RequestBody CarDTO CarDTO) {

        Car car = carService.saveCar(CarDTO);
        UICar uiCar = UIConverter.convertCarResponse(car);
        return new ResponseEntity<>(uiCar, HttpStatus.OK);
    }

    @Operation(summary = "Update a car")
    @PutMapping(value = "/update-car/{carId}", consumes = "application/json", produces = "application/json")
    public ResponseEntity<Car> updateCarById(@PathVariable(name = "carId") Integer carId, @RequestBody CarDTO CarDTO) {

        Car p = carService.getCarById(carId);
        if (p != null) {
            Car car = carService.updateCarById(carId, CarDTO);
            return new ResponseEntity<Car>(car, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find car with the id: " + carId);
        }
    }

    @Operation(summary = "Delete a car")
    @DeleteMapping("/car/{carId}")
    public void deleteCarById(@PathVariable Integer carId) {

        if (carService.isCarIdPresent(carId)) {
            carService.deleteCarById(carId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No car with the id " + carId + " was found.");
        }
    }
}
