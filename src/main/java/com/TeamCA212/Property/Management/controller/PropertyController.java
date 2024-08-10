package com.TeamCA212.Property.Management.controller;
import com.TeamCA212.Property.Management.model.Property;
import com.TeamCA212.Property.Management.service.PropertyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/properties")
public class PropertyController {
    @Autowired
    private PropertyService propertyService;

    @GetMapping
    public String getAllProperties(Model model) {
        model.addAttribute("properties", propertyService.getAllProperties());
        return "properties";
    }

    @GetMapping("/{id}")
    public String getPropertyById(@PathVariable Long id, Model model) {
        model.addAttribute("property", propertyService.getPropertyById(id));
        return "view-property";
    }

    @GetMapping("/add")
    public String addPropertyForm(Model model) {
        model.addAttribute("property", new Property());
        return "add-property";
    }

    @PostMapping
    public String addProperty(@ModelAttribute Property property) {
        propertyService.addProperty(property);
        return "redirect:/properties";
    }

    @GetMapping("/update/{id}")
    public String updatePropertyForm(@PathVariable Long id, Model model) {
        model.addAttribute("property", propertyService.getPropertyById(id));
        return "update-property";
    }

    @PostMapping("/update/{id}")
    public String updateProperty(@PathVariable Long id, @ModelAttribute Property propertyDetails) {
        propertyService.updateProperty(id, propertyDetails);
        return "redirect:/properties";
    }

    @GetMapping("/delete/{id}")
    public String deleteProperty(@PathVariable Long id) {
        propertyService.deleteProperty(id);
        return "redirect:/properties";
    }
}
