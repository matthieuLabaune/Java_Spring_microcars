package com.ecars.microcars.controller;

import java.util.ArrayList;
import java.util.List;

import com.ecars.microcars.form.CarForm;
import com.ecars.microcars.model.Car;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class MainController {

    private static List<Car> cars = new ArrayList<Car>();

    static {
        cars.add(new Car ("Honda", "Jazz"));
        cars.add(new Car ("Volvo", "940"));
        cars.add(new Car( "Opel", "Corsa"));
    }

    // Injectez (inject) via application.properties.
    @Value("${welcome.message}")
    private String message;

    @Value("${error.message}")
    private String errorMessage;

    @RequestMapping(value = { "/", "/index" }, method = RequestMethod.GET)
    public String index(Model model) {

        model.addAttribute("message", message);

        return "index";
    }

    @RequestMapping(value = { "/carList" }, method = RequestMethod.GET)
    public String carList(Model model) {

        model.addAttribute("cars", cars);

        return "carList";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.GET)
    public String showAddCarPage(Model model) {

        CarForm carForm = new CarForm();
        model.addAttribute("carForm", carForm);

        return "addCar";
    }

    @RequestMapping(value = { "/addCar" }, method = RequestMethod.POST)
    public String saveCar(Model model, //
                             @ModelAttribute("carForm") CarForm carForm) {

        String brand = carForm.getBrand();
        String modele = carForm.getModele();

        if (brand != null && brand.length() > 0 //
                && modele != null && modele.length() > 0) {
            Car newCar = new Car(brand, modele);
            cars.add(newCar);

            return "redirect:/carList";
        }

        model.addAttribute("errorMessage", errorMessage);
        return "addCar";
    }

}
