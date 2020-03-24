package pl.pawel.ksb2thymeleaf.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import pl.pawel.ksb2thymeleaf.model.Car;
import pl.pawel.ksb2thymeleaf.service.CarService;


@Controller
public class MainController {

    private CarService carService;

    @Autowired
    public MainController(CarService carService) {
        this.carService = carService;
    }

    @GetMapping("/")
    public String home(Model model) {
        model.addAttribute("cars", carService.getCarList());
        model.addAttribute("newCar", new Car());
        model.addAttribute("editCar", new Car());
        return "mainPage";
    }


    @PostMapping("/delete-car")
    public String deleteCar(@RequestParam long id) {
        carService.deleteCarByID(id);
        return "redirect:/";
    }

    @PostMapping("/add-car")
    public String addCar(@ModelAttribute Car newCar) {
        System.out.println("add : " + newCar);
        carService.addcar(newCar);
        return "redirect:/";
    }

    @PostMapping("edit-car")
    public String editCar(@ModelAttribute Car editcar) {
        if (carService.editCar(editcar)) {
            return "redirect:/";
        }
        return "error";
    }
}