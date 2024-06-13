package com.mixalismavromanolakis.car_service_tasks.EntityConverter;

import com.mixalismavromanolakis.car_service_tasks.DTO.CarDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Car;
import org.springframework.stereotype.Service;

@Service
public class CarEntityConverter implements EntityConverter<Car, CarDTO> {

    @Override
    public CarDTO convertToDTO(Car carEntity) {
        CarDTO CarDTO = new CarDTO();
        CarDTO.carName = carEntity.getName();
        CarDTO.carId = carEntity.getcarId();

        if (carEntity.getStatusOfCar() != null) {

            CarDTO.statusName = carEntity.getStatusOfCar().getStatusName();
        } else {

            CarDTO.statusName = "Undefined Status";
        }
        return CarDTO;
    }

    @Override
    public Car convertToEntity(CarDTO CarDTO) {

        Car carEntity = new Car();

        carEntity.setName(CarDTO.carName);
        carEntity.setDescription(CarDTO.description);
        return carEntity;
    }
}
