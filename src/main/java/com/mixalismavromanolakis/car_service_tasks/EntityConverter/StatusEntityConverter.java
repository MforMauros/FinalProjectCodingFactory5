package com.mixalismavromanolakis.car_service_tasks.EntityConverter;

import com.mixalismavromanolakis.car_service_tasks.DTO.StatusDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Status;
import org.springframework.stereotype.Service;

@Service
public class StatusEntityConverter implements EntityConverter<Status, StatusDTO> {

    @Override
    public StatusDTO convertToDTO(Status statusEntity) {
        StatusDTO statusDTO = new StatusDTO();
        statusDTO.statusName = statusEntity.getStatusName();
        statusDTO.statusId = statusEntity.getStatusId();
        return statusDTO;
    }

    @Override
    public Status convertToEntity(StatusDTO statusDTO) {

        Status statusEntity = new Status();
        statusEntity.setStatusName(statusDTO.statusName);
        return statusEntity;
    }
}
