package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.Car;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface CarRepository extends JpaRepository<Car, Integer> {

    List<Car> findByName(String name);

    Optional<Car> findCarByCarId(Integer carId);

}
