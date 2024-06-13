package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.Manager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ManagerRepository  extends JpaRepository<Manager, Long> {
}
