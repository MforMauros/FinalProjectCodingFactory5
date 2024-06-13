package com.mixalismavromanolakis.car_service_tasks.WebPageControllers;

import com.mixalismavromanolakis.car_service_tasks.Repositories.TaskRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class TasksWebController {

    private final TaskRepository taskRepository;

    public TasksWebController(TaskRepository taskRepository) {
        this.taskRepository = taskRepository;
    }

    @GetMapping("/tasks")
    public ModelAndView tasksPage() {
        ModelAndView modelAndView = new ModelAndView("tasks");

        return modelAndView;
    }
}
