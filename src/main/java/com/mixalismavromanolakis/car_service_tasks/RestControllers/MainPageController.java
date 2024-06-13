package com.mixalismavromanolakis.car_service_tasks.RestControllers;

import com.mixalismavromanolakis.car_service_tasks.Entities.Role;
import com.mixalismavromanolakis.car_service_tasks.Entities.User;
import com.mixalismavromanolakis.car_service_tasks.Services.CarService;
import com.mixalismavromanolakis.car_service_tasks.Services.StatusService;
import com.mixalismavromanolakis.car_service_tasks.Services.MechanicService;
import com.mixalismavromanolakis.car_service_tasks.Services.UserService;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
@Tag(name = "Main Page", description = "Main Page Controller")
public class MainPageController {

    @Autowired
    CarService carService;

    @Autowired
    StatusService statusService;

    @Autowired
    MechanicService mechanicService;

    @Autowired
    UserService userService;

    @Operation(summary = "View the main page")
    @GetMapping("/")
    public ModelAndView mainPage(Principal principal) {
        ModelAndView modelAndView = new ModelAndView("login");

        if (principal == null) return modelAndView;

        User user = userService.getUserByUsername(principal.getName());
        String role = user.getRole().name();

        if (role.equals(Role.MANAGER.toString())) {
            modelAndView = new ModelAndView("admin_dashboard");

        }

        if (role.equals(Role.MECHANIC.toString())) {
            modelAndView = new ModelAndView("mechanics_dashboard");
        }

        return modelAndView;
    }
}
