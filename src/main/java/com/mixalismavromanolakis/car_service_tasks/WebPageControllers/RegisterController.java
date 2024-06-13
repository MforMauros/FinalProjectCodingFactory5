package com.mixalismavromanolakis.car_service_tasks.WebPageControllers;

import com.mixalismavromanolakis.car_service_tasks.DTO.RegisterDTO;
import com.mixalismavromanolakis.car_service_tasks.Entities.Manager;
import com.mixalismavromanolakis.car_service_tasks.Entities.Role;
import com.mixalismavromanolakis.car_service_tasks.Services.Exceptions.ManagerAlreadyExistsException;
import com.mixalismavromanolakis.car_service_tasks.Services.Exceptions.MechanicAlreadyExistsException;
import com.mixalismavromanolakis.car_service_tasks.Services.ManagerService;
import com.mixalismavromanolakis.car_service_tasks.Services.MechanicService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.ModelAndView;

import java.util.Objects;


@Controller
public class RegisterController {

    @Autowired
    ManagerService managerService;

    @Autowired
    MechanicService mechanicService;

    @GetMapping("/register")
    public ModelAndView register(Model model) {
        model.addAttribute("userForm", new RegisterDTO());
        ModelAndView modelAndView = new ModelAndView("register");
        return modelAndView;
    }

    @PostMapping("/register")
    public String registerUser(@Valid @ModelAttribute("userForm") RegisterDTO registerDTO,
                               BindingResult bindingResult) throws ManagerAlreadyExistsException, MechanicAlreadyExistsException {

        if (bindingResult.hasErrors()) {
            return "register";
        }

        System.out.println("Registered with username: " + registerDTO.getUsername());
        System.out.println("Role: " + registerDTO.getRole());  // Output the selected role

        try {
            if (Objects.equals(registerDTO.getRole(), Role.MANAGER.toString())) {
                RegisterDTO managerDTO = new RegisterDTO(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getFirstname(), registerDTO.getLastname(), registerDTO.getEmailAddress(), Role.MANAGER.toString());
                managerService.registerManager(managerDTO);
            } else {
                RegisterDTO mechanicDTO = new RegisterDTO(registerDTO.getUsername(), registerDTO.getPassword(), registerDTO.getFirstname(), registerDTO.getLastname(), registerDTO.getEmailAddress(), Role.MECHANIC.toString());
                mechanicService.registerMechanic(mechanicDTO);
            }
        } catch (ManagerAlreadyExistsException e) {
            throw e;
        } catch (MechanicAlreadyExistsException e) {
            throw new RuntimeException(e);
        }

        return "redirect:/login";
    }

}
