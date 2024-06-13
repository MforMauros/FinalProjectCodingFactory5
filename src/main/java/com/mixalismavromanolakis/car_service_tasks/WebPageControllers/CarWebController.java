package com.mixalismavromanolakis.car_service_tasks.WebPageControllers;

import com.mixalismavromanolakis.car_service_tasks.Repositories.CarRepository;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class CarWebController {

    private final CarRepository carRepository;

    public CarWebController(CarRepository carRepository) {
        this.carRepository = carRepository;
    }

    @GetMapping("/cars")
    public ModelAndView carsPage() {
        ModelAndView modelAndView = new ModelAndView("cars");

        return modelAndView;
    }
}
