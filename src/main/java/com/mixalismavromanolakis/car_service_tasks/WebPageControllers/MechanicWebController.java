package com.mixalismavromanolakis.car_service_tasks.WebPageControllers;

import com.mixalismavromanolakis.car_service_tasks.Repositories.MechanicRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MechanicWebController {

    private final MechanicRepository mechanicRepository;

    public MechanicWebController(MechanicRepository mechanicRepository) {
        this.mechanicRepository = mechanicRepository;
    }

    @GetMapping("/mechanics")
    public ModelAndView mechanicsPage() {
        ModelAndView modelAndView = new ModelAndView("mechanics");

        return modelAndView;
    }
}
