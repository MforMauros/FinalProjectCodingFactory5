package com.mixalismavromanolakis.car_service_tasks.EntityConverter;

import com.mixalismavromanolakis.car_service_tasks.DTO.MechanicDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Mechanic;
import org.springframework.stereotype.Service;

@Service
public class MechanicEntityConverter implements EntityConverter<Mechanic, MechanicDTO> {

    @Override
    public MechanicDTO convertToDTO(Mechanic mechanicEntity) {
        MechanicDTO mechanicDTO = new MechanicDTO();
        mechanicDTO.mechanicLastName = mechanicEntity.getLastName();
        mechanicDTO.mechanicFirstName = mechanicEntity.getFirstName();
        mechanicDTO.mechanicEmailAddress = mechanicEntity.getEmailAddress();
        return mechanicDTO;
    }

    @Override
    public Mechanic convertToEntity(MechanicDTO mechanicDTO) {
        Mechanic mechanicEntity = new Mechanic();
        mechanicEntity.setLastName(mechanicDTO.mechanicLastName);
        mechanicEntity.setFirstName(mechanicDTO.mechanicFirstName);
        mechanicEntity.setEmailAddress(mechanicDTO.mechanicEmailAddress);
        return mechanicEntity;
    }
}
