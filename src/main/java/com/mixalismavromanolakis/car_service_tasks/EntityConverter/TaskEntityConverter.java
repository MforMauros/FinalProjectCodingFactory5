package com.mixalismavromanolakis.car_service_tasks.EntityConverter;

import com.mixalismavromanolakis.car_service_tasks.DTO.TaskDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Task;
import org.springframework.stereotype.Service;

@Service
public class TaskEntityConverter implements EntityConverter<Task, TaskDTO> {

    @Override
    public TaskDTO convertToDTO(Task taskEntity) {

        TaskDTO taskDTO = new TaskDTO();
        taskDTO.taskId = taskEntity.getTaskId();
        taskDTO.title = taskEntity.getTitle();
        taskDTO.description = taskEntity.getDescription();
        taskDTO.statusOfTask = taskEntity.getStatusOfTask().getStatusName();
        taskDTO.typeOfTask = taskEntity.getTypeOfTask().getName();

        if (taskEntity.getStatusOfTask() != null && taskEntity.getTypeOfTask() != null) {

            taskDTO.statusOfTask = taskEntity.getStatusOfTask().getStatusName();
            taskDTO.typeOfTask = taskEntity.getTypeOfTask().getName();
        } else if (taskEntity.getStatusOfTask() == null){

            taskDTO.statusOfTask = "Undefined Status";
        } else if (taskEntity.getTypeOfTask() == null) {

            taskDTO.typeOfTask = "Undefined Type";
        }
        return taskDTO;
    }

    @Override
    public Task convertToEntity(TaskDTO taskDTO) {

        Task taskEntity = new Task();

        taskEntity.setTitle(taskDTO.title);
        taskEntity.setDescription(taskDTO.description);
        return taskEntity;
    }
}
