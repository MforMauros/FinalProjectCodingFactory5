package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.Type;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface TypeRepository extends JpaRepository<Type, Integer> {

    Optional<Type> findByName(String typeName);
}
