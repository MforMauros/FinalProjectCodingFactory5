package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.TaskDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Task;
import com.mixalismavromanolakis.car_service_tasks.Services.TaskService;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIConverter;
import com.mixalismavromanolakis.car_service_tasks.UIConverter.UIObjects.UITask;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;
import java.util.List;

@RestController
@RequestMapping("/api/v1")
@Tag(name = "Task Management System", description = "Operations pertaining to tasks in Task Management System")
public class TaskController {

    @Autowired
    TaskService taskService;

    @Autowired
    UIConverter UIConverter;

    public TaskController(TaskService taskService) {
        this.taskService = taskService;
    }

    @Operation(summary = "View a list of available tasks")
    @GetMapping(value = "/tasks", produces = "application/json")
    public ResponseEntity<List<TaskDTO>> getAllTasks() {

        List<TaskDTO> allTasksDTO = taskService.getAllTasks();
        return new ResponseEntity<List<TaskDTO>>(allTasksDTO, HttpStatus.OK);
    }

    @Operation(summary = "Get a task by Id")
    @GetMapping(value = "/task/id/{taskId}", produces = "application/json")
    public ResponseEntity<TaskDTO> getTaskById(@PathVariable Integer taskId) {

        Task taskById = taskService.findByTaskId(taskId);
        if (taskById != null) {
            Task taskEntity = taskById;
            TaskDTO taskDTO = new TaskDTO(taskEntity);
            return new ResponseEntity<TaskDTO>(taskDTO, HttpStatus.OK);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No task with the id " + taskId + " was found.");
        }
    }

    @Operation(summary = "Add a new task")
    @PostMapping(value = "add-new-task", consumes = "application/json")
    public ResponseEntity<UITask> createTask(@RequestBody TaskDTO taskDTO) {

        Task task = taskService.saveNewTask(taskDTO);
        UITask uiTask = UIConverter.convertTaskResponse(task);
        return new ResponseEntity<>(uiTask, HttpStatus.OK);
    }

    @Operation(summary = "Update a task by Id")
    @PutMapping(value = "/update-task/{taskId}", consumes = "application/json")
    public ResponseEntity<Task> updateTaskById(@PathVariable(name = "taskId") Integer taskId, @RequestBody TaskDTO taskDTO) {

        Task p = taskService.findByTaskId(taskId);
        if (p != null) {
            Task task = taskService.updateTaskById(taskId, taskDTO);
            return new ResponseEntity<Task>(task, HttpStatus.OK);
        }
        else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "Could not find task with the id: " + taskId);
        }
    }

    @Operation(summary = "Delete a task by Id")
    @DeleteMapping("/task/{taskId}")
    public void deleteTaskById(@PathVariable Integer taskId) {

        if (taskService.isTaskIdPresent(taskId)) {
            taskService.deleteTaskById(taskId);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "No task with the id " + taskId + " was found.");
        }
    }
}
