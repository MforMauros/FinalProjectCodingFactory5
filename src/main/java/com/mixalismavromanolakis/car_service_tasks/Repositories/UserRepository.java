package com.mixalismavromanolakis.car_service_tasks.Repositories;

import com.mixalismavromanolakis.car_service_tasks.Entities.AuthenticationStatus;
import com.mixalismavromanolakis.car_service_tasks.Entities.Role;
import com.mixalismavromanolakis.car_service_tasks.Entities.Status;
import com.mixalismavromanolakis.car_service_tasks.Entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<User, Long> {
    Optional<User> findByRole(Role role);
    Optional<User> findByUsername(String username);
    Long countByRole(Role role);
    Long countByRoleAndAuthenticationStatus(Role role, AuthenticationStatus authenticationStatus);
}
