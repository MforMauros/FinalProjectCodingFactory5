package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.Mechanic;
import org.springframework.data.jpa.repository.JpaRepository;
import java.util.Optional;

public interface MechanicRepository extends JpaRepository<Mechanic, Integer> {

    Optional<Mechanic> findByMechanicId (Integer id);

    Mechanic findByLastName(String lastName);

    Mechanic findByFirstName(String firstName);

    Mechanic findByEmailAddress(String emailAddress);
}
