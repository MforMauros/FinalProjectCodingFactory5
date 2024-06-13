package com.mixalismavromanolakis.car_service_tasks.Mapper;

import com.mixalismavromanolakis.car_service_tasks.DTO.RegisterDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Manager;
import com.mixalismavromanolakis.car_service_tasks.Entities.Mechanic;
import com.mixalismavromanolakis.car_service_tasks.Entities.User;
import org.springframework.stereotype.Component;

@Component

public class Mapper {

    private Mapper() {}

    public static Manager extractManagerFromRegisterManagerDTO(RegisterDTO dto) {
        return new Manager(dto.getFirstname(), dto.getLastname(),dto.getEmailAddress(), true);
    }

    public static User extractUserFromRegisterManagerDTO(RegisterDTO dto) {
        User user = User.getNewUserWithManagerRole(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }

    public static Mechanic extractMechanicFromRegisterMechanicDTO(RegisterDTO dto) {
        return new Mechanic(dto.getFirstname(), dto.getLastname(), true);
    }

    public static User extractUserFromRegisterMechanicDTO(RegisterDTO dto) {
        User user = User.getNewUserWithMechanicRole(dto.getUsername(), dto.getPassword());
        user.setIsActive(true);
        return user;
    }
}
