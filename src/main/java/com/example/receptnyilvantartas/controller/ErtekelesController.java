package com.example.receptnyilvantartas.controller;

import com.example.receptnyilvantartas.model.Ertekeles;
import com.example.receptnyilvantartas.service.ErtekelesService;
import com.example.receptnyilvantartas.service.FelhasznaloService;
import com.example.receptnyilvantartas.service.ReceptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/ertekelesek")
public class ErtekelesController {
    private final ErtekelesService ertekelesService;
    private final ReceptService receptService;
    private final FelhasznaloService felhasznaloService;

    public ErtekelesController(ErtekelesService ertekelesService,
                               ReceptService receptService,
                               FelhasznaloService felhasznaloService) {
        this.ertekelesService = ertekelesService;
        this.receptService = receptService;
        this.felhasznaloService = felhasznaloService;
    }
    @GetMapping
    public String list(Model model) {
        model.addAttribute("ertekelesek", ertekelesService.findAll());
        return "ertekelesek";
    }
    @GetMapping("/uj")
    public String ujForm(Model model) {
        model.addAttribute("ertekeles", new Ertekeles());
        model.addAttribute("receptek", receptService.findAll());
        model.addAttribute("felhasznalok", felhasznaloService.findAll());
        return "ertekeles-form";
    }
    @PostMapping
    public String mentes(@ModelAttribute Ertekeles ertekeles) {
        if (ertekeles.getRecept() == null || ertekeles.getRecept().getId() == null) {
            throw new RuntimeException("Recept hiányzik az értékelésből!");
        }
        if (ertekeles.getFelhasznalo() == null || ertekeles.getFelhasznalo().getId() == null) {
            throw new RuntimeException("Felhasználó hiányzik az értékelésből!");
        }
        ertekeles.setRecept(receptService.findById(ertekeles.getRecept().getId()));
        ertekeles.setFelhasznalo(felhasznaloService.findById(ertekeles.getFelhasznalo().getId()));

        ertekelesService.save(ertekeles);
        return "redirect:/ertekelesek";
    }
    @GetMapping("/torol/{id}")
    public String torles(@PathVariable Long id) {
        ertekelesService.deleteById(id);
        return "redirect:/ertekelesek";
    }
}
