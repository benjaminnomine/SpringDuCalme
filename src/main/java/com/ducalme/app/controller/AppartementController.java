package com.ducalme.app.controller;

import com.ducalme.app.models.*;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/appartement/")
public class AppartementController {

    private final AppartementRepositery appartementRepositery;

    public AppartementController(AppartementRepositery appartementRepositery) {
        this.appartementRepositery = appartementRepositery;
    }

    @GetMapping("ajout")
    public String addAppart(Model model) {
        Appartement appartement = new Appartement();
        model.addAttribute("appartement", appartement);
        return "appartement/index";
    }

    @PostMapping("index")
    public String addAppart(@RequestParam String nom, Model model) { // TODO : changer les paramètres pour intégrer toutes les colonnes
        Appartement appartement = new Appartement();
        try {
            appartementRepositery.save(appartement);
            model.addAttribute("message", "Insertion réussie.");
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
            model.addAttribute("message", "Insertion échouée.");
        }
        return "appartement/index";
    }

    @GetMapping("index")
    public String getAppartements(Model model)
    {
        List<Appartement> appartements = (List<Appartement>) appartementRepositery.findAll();
        model.addAttribute("appartements", appartements);
        return "appartement/index";
    }

    @GetMapping("{id}")
    public String findLocataireById(@PathVariable Integer id, Model model) {
        Appartement appartement = appartementRepositery.searchAppartementById(id);
        if(appartement !=null) {
            model.addAttribute(appartement);
            return "appartement/detail";
        }
        else {
            model.addAttribute("message", "Pas d'appartement avec cet Id");
            return "appartement/index";
        }
    }
}
