package com.example.receptnyilvantartas.controller;

import com.example.receptnyilvantartas.model.Felhasznalo;
import com.example.receptnyilvantartas.service.FelhasznaloService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
@Controller
@RequestMapping("/felhasznalok")
public class FelhasznaloController {
    private final FelhasznaloService service;
    public FelhasznaloController(FelhasznaloService service)
    {
        this.service = service;
    }
    @GetMapping
    public String list(Model model) {
        model.addAttribute("felhasznalok", service.findAll());
        return "felhasznalok"; // hozz létre egy felhasznalok.html nézetet
    }
    @GetMapping("/uj")
    public String ujForm(Model model) {
        model.addAttribute("felhasznalo", new Felhasznalo());
        return "felhasznalo-form";
    }
    @PostMapping
    public String mentes(@ModelAttribute Felhasznalo felhasznalo)
    {
        service.save(felhasznalo);
        return "redirect:/felhasznalok";
    }
    @GetMapping("/torol/{id}")
    public String torles(@PathVariable Long id)
    {
        service.deleteById(id);
        return "redirect:/felhasznalok";
    }
}
