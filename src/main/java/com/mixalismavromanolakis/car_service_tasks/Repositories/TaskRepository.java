package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.Task;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import java.util.List;
import java.util.Optional;

@Repository
public interface TaskRepository extends JpaRepository<Task, Integer> {
    Optional<Task> findByTaskId(Integer taskId);

    List<Task> findByTitle(String title);
}
