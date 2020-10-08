package com.ducalme.app.controller;

import com.ducalme.app.models.Appartement;
import com.ducalme.app.models.Bail;
import com.ducalme.app.models.Locataire;
import com.ducalme.app.services.AppartementService;
import com.ducalme.app.services.BailService;
import com.ducalme.app.services.LocataireService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Controller
@RequestMapping(value = "/bail/")
public class BailController {

    private final BailService bailService;
    private final AppartementService appartementService;
    private final LocataireService locataireService;

    public BailController(BailService bailService, AppartementService appartementService, LocataireService locataireService) {
        this.bailService = bailService;
        this.appartementService = appartementService;
        this.locataireService = locataireService;
    }

    @GetMapping("ajout/appartement/{id}")
    public String addBailByAppartementId(@PathVariable(value = "id") Integer id, Model model) {
        Optional appart = appartementService.findById(id);
        if(appart.isPresent())
        {
            Appartement appartement = (Appartement) appart.get();
            model.addAttribute("appartement", appartement);
        }
        Bail bail = new Bail();
        List<Locataire> locataires = locataireService.findAll();
        model.addAttribute("locataires", locataires);
        model.addAttribute("bail", bail);
        return "bail/createappart";
    }

    @GetMapping("ajout/locataire/{id}")
    public String addBailByLocataireId(@PathVariable(value = "id") Integer id, Model model) {
        Optional locataireOptional = locataireService.findById(id);
        if(locataireOptional.isPresent()) {
            Locataire locataire =(Locataire) locataireOptional.get();
            model.addAttribute("locataire", locataire);
        }
        Bail bail = new Bail();
        List<Appartement> appartements = appartementService.findAll();
        model.addAttribute("appartements", appartements);
        model.addAttribute("bail", bail);
        return "bail/createlocataire";
    }

    @PostMapping("addEdit")
    private String insertOrUpdate(Bail bail, Model model){
        if(bail.getId() == null){
            bailService.save(bail);
        }else{
            Optional<Bail> bailOptional = bailService.findById(bail.getId());
            if(bailOptional.isPresent()){
                Bail temp = bailOptional.get();
                temp.setDuree(bail.getDuree());
                temp.setDateSignature(bail.getDateSignature());
                bailService.save(temp);
            }
        }
        List<Bail> bails = bailService.findAll();
        model.addAttribute("bails", bails);
        return "bail/index";
    }

    @GetMapping("index")
    public String getBails(Model model)
    {
        List<Bail> bails = bailService.findAll();
        model.addAttribute("bails", bails);
        return "bail/index";
    }

    @GetMapping(path = {"ajout", "update/{id}"})
    private String addForm(@PathVariable("id") Optional<Integer> id, Model model){
        if(id.isPresent()){
            Optional bailOptional = bailService.findById(id.get());
            if(bailOptional.isPresent()) {
                Bail bail = (Bail) bailOptional.get();
                model.addAttribute("bail", bail);
            }
        }else{
            Bail bail = new Bail();
            model.addAttribute("bail", bail);
        }
        List<Appartement> appartements= appartementService.findAll();
        model.addAttribute("appartements", appartements);
        List<Locataire> locataires = locataireService.findAll();
        model.addAttribute("locataires", locataires);
        List<Bail> bails = bailService.findAll();
        model.addAttribute("bails", bails);
        return "bail/create";
    }

    @GetMapping("{id}")
    public String findBailById(@PathVariable(value = "id") Integer id, Model model) {
        Optional bailOptional = bailService.findById(id);
        if(bailOptional.isPresent()) {
            Bail bail =(Bail) bailOptional.get();
            model.addAttribute("bail", bail);
            return "bail/detail";
        }
        else {
            List<Bail> bails = bailService.findAll();
            model.addAttribute("bails", bails);
            model.addAttribute("message", "Pas de bail avec cet Id");
            return "redirect:";
        }
    }

    @RequestMapping(value = "delete/{id}", method = RequestMethod.GET)
    public String deleteBail(@PathVariable(value = "id") Integer id, Model model) throws ModelNotFoundException {
        Optional bailOptional = bailService.findById(id);
        if(bailOptional.isPresent()) {
            Bail bail = (Bail) bailOptional.get();
            bailService.deleteById(bail.getId());
        } else {
            throw new ModelNotFoundException("Le bail avec l'id " + id + " n'a pas été trouvé.");
        }
        List<Bail> bails = bailService.findAll();
        model.addAttribute("bails", bails);
        return "bail/index";
    }
}
