
package com.mixalismavromanolakis.car_service_tasks.WebPageControllers;

import com.mixalismavromanolakis.car_service_tasks.Entities.Role;
import com.mixalismavromanolakis.car_service_tasks.Entities.User;
import com.mixalismavromanolakis.car_service_tasks.Services.UserService;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

import java.security.Principal;

@Controller
public class LoginController {

    @Autowired
    UserService userService;

    @GetMapping("/login")
    public ModelAndView login(Model model, Principal principal, HttpServletRequest request) {
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
