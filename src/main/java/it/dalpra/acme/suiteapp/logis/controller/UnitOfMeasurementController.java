package it.dalpra.acme.suiteapp.logis.controller;

import it.dalpra.acme.suiteapp.logis.entity.UnitOfMeasurement;
import it.dalpra.acme.suiteapp.logis.service.UnitOfMeasurementService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/unitofmeasurement")
public class UnitOfMeasurementController {

    private final UnitOfMeasurementService service;

    public UnitOfMeasurementController(UnitOfMeasurementService service) {
        this.service = service;
    }

    @GetMapping("/unit-of-measurement-management")
    public String showUnitOfMeasurementManagement(Model model) {
        model.addAttribute("units", service.findAll());
        return "unitofmeasurement/unit-of-measurement-management";
    }

    @PostMapping("/add")
    public String addUnitOfMeasurement(UnitOfMeasurement unit) {
        service.save(unit);
        return "redirect:/unitofmeasurement/unit-of-measurement-management";
    }
}