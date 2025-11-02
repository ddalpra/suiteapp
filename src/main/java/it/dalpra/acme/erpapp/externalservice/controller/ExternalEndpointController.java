package it.dalpra.acme.erpapp.externalservice.controller;

import it.dalpra.acme.erpapp.externalservice.entity.ExternalEndpoint;
import it.dalpra.acme.erpapp.externalservice.service.ExternalEndpointService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@Controller
@RequestMapping("/external-endpoints")
public class ExternalEndpointController {

    private final ExternalEndpointService externalEndpointService;

    public ExternalEndpointController(ExternalEndpointService externalEndpointService) {
        this.externalEndpointService = externalEndpointService;
    }

    @GetMapping
    public String list(Model model) {
        model.addAttribute("endpoints", externalEndpointService.getAllEndpoints());
        return "external-endpoints";
    }

    @GetMapping("/new")
    public String createForm(Model model) {
        model.addAttribute("endpoint", new ExternalEndpoint());
        return "external-endpoint-form";
    }

    @PostMapping
    public String save(@ModelAttribute ExternalEndpoint endpoint) {
        externalEndpointService.saveEndpoint(endpoint);
        return "redirect:/external-endpoints";
    }

    @GetMapping("/edit/{id}")
    public String editForm(@PathVariable UUID id, Model model) {
        model.addAttribute("endpoint", externalEndpointService.getEndpointById(id).orElse(null));
        return "external-endpoint-form";
    }

    @PostMapping("/update/{id}")
    public String update(@PathVariable UUID id, @ModelAttribute ExternalEndpoint endpoint) {
        endpoint.setId(id);
        externalEndpointService.saveEndpoint(endpoint);
        return "redirect:/external-endpoints";
    }

    @GetMapping("/delete/{id}")
    public String delete(@PathVariable UUID id) {
        externalEndpointService.deleteEndpoint(id);
        return "redirect:/external-endpoints";
    }
}
