package com.ducalme.app.controller;

import com.ducalme.app.models.*;
import com.ducalme.app.services.AppartementService;
import com.ducalme.app.services.TypeAppartementService;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping("/appartement/")
public class AppartementController {

    private final AppartementService appartementService;
    private final TypeAppartementService typeAppartementService;

    public AppartementController(AppartementService appartementService, TypeAppartementService typeAppartementService) {
        this.appartementService = appartementService;
        this.typeAppartementService = typeAppartementService;
    }

    @PostMapping("addEdit")
    private String insertOrUpdate(Appartement appartement, Model model){
        if(appartement.getId() == null){
            appartementService.save(appartement);
        }else{
            Optional<Appartement> appartementOptional = appartementService.findById(appartement.getId());
            if(appartementOptional.isPresent()){
                Appartement temp = appartementOptional.get();
                temp.setDescription(appartement.getDescription());
                temp.setSurface(appartement.getSurface());
                temp.setTypeAppartement(appartement.getTypeAppartement());
                appartementService.save(temp);
            }
        }
        List<Appartement> appartements = appartementService.findAll();
        List<TypeAppartement> types = typeAppartementService.findAll();
        model.addAttribute("types", types);
        model.addAttribute("appartements", appartements);
        return "appartement/index";
    }

    @GetMapping("index")
    public String getAppartements(Model model)
    {
        List<Appartement> appartements = appartementService.findAll();
        model.addAttribute("appartements", appartements);
        return "appartement/index";
    }

    @GetMapping(path = {"ajout", "update/{id}"})
    private String addForm(@PathVariable("id") Optional<Integer> id, Model model){
        if(id.isPresent()){
            Optional appartOptional = appartementService.findById(id.get());
            if(appartOptional.isPresent()) {
                Appartement appartement = (Appartement) appartOptional.get();
                List<TypeAppartement> types = typeAppartementService.findAll();
                model.addAttribute("types", types);
                model.addAttribute("appartement", appartement);
            }
        }else{
            Appartement appartement = new Appartement();
            List<TypeAppartement> types = typeAppartementService.findAll();
            model.addAttribute("types", types);
            model.addAttribute("appartement", appartement);
        }
        return "appartement/create";
    }

    @GetMapping("{id}")
    public String findAppartementById(@PathVariable(value = "id") Integer id, Model model) {
        Optional appart = appartementService.findById(id);
        if(appart.isPresent()) {
            Appartement appartement =(Appartement) appart.get();
            model.addAttribute("appartement", appartement);
            return "appartement/detail";
        }
        else {
            List<Appartement> appartements = appartementService.findAll();
            model.addAttribute("appartements", appartements);
            model.addAttribute("message", "Pas d'appartement avec cet Id");
            return "redirect:";
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteAppartement(@PathVariable(value = "id") Integer id, Model model) throws ModelNotFoundException {
        Optional appartement = appartementService.findById(id);
        if(appartement.isPresent()) {
            Appartement appart = (Appartement) appartement.get();
            appartementService.deleteById(appart.getId());
        }
        else {
            throw new ModelNotFoundException("L'appartement avec l'id " + id + " n'a pas été trouvé.");
        }
        List<Appartement> appartements = appartementService.findAll();
        model.addAttribute("appartements", appartements);
        return "appartement/index";
    }
}
