package com.ducalme.app.controller;

import com.ducalme.app.exceptions.LocataireNotFoundException;
import com.ducalme.app.models.*;
import com.ducalme.app.services.LocataireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/locataire/")
public class LocataireController {

    private final LocataireService locataireService;

    public LocataireController(LocataireService locataireService) {
        this.locataireService = locataireService;
    }

    @GetMapping("ajout")
    public String addLocataire(Model model) {
        Locataire locataire = new Locataire();
        model.addAttribute("locataire", locataire);
        return "locataire/create";
    }

    @PostMapping("ajout")
    public String addLocataire(@ModelAttribute Locataire locataire, BindingResult result, Model model) {
        if(!result.hasErrors()) {
            try {
                locataireService.save(locataire);
                List<Locataire> locataires = locataireService.findAll();
                model.addAttribute("locataires", locataires);
                model.addAttribute("message", "Insertion réussie.");
            }
            catch (Exception e)
            {
                List<Locataire> locataires = locataireService.findAll();
                model.addAttribute("locataires", locataires);
                model.addAttribute("message", "Insertion échouée.");
            }
        }
        return "locataire/index";
    }

    @GetMapping("index")
    public String getLocataires(Model model)
    {
        List<Locataire> locataires = locataireService.findAll();
        model.addAttribute("locataires", locataires);
        return "locataire/index";
    }

    @GetMapping("{id}")
    public String findLocataireById(@PathVariable(value = "id") Integer id, Model model) {
        Optional locataire = locataireService.findById(id);
        if(locataire.isPresent()) {
            Locataire loca =(Locataire) locataire.get();
            model.addAttribute(loca);
            return "locataire/detail";
        }
        else {
            List<Locataire> locataires = locataireService.findAll();
            model.addAttribute("locataires", locataires);
            model.addAttribute("message", "Pas de locataire avec cet Id");
            return "redirect:";
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteLocataire(@PathVariable(value = "id") Integer id, Model model) throws LocataireNotFoundException {
        Optional locataire = locataireService.findById(id);
        if(locataire.isPresent()) {
            Locataire loca = (Locataire)locataire.get();
            locataireService.deleteById(loca.getId());
        }
        else {
            throw new LocataireNotFoundException("Le locataire avec l'id " + id + " n'a pas été trouvé.");
        }
        List<Locataire> locataires = locataireService.findAll();
        model.addAttribute("locataires", locataires);
        return "locataire/index";
    }

}
