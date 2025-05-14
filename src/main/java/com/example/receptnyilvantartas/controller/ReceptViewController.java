package com.example.receptnyilvantartas.controller;

import com.example.receptnyilvantartas.model.Recept;
import com.example.receptnyilvantartas.service.ReceptService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/receptek")
public class ReceptViewController {

    private final ReceptService receptService;

    public ReceptViewController(ReceptService receptService) {
        this.receptService = receptService;
    }

    @GetMapping
    public String listReceptek(Model model) {
        model.addAttribute("receptek", receptService.findAll());
        return "receptek";
    }

    @GetMapping("/uj")
    public String ujReceptForm(Model model) {
        model.addAttribute("recept", new Recept());
        return "uj";
    }

    @PostMapping
    public String mentes(@ModelAttribute Recept recept) {
        receptService.save(recept);
        return "redirect:/receptek";
    }

    @PostMapping("/torol/{id}")
    public String torles(@PathVariable Long id) {
        receptService.deleteById(id);
        return "redirect:/receptek";
    }

    @GetMapping("/szerkeszt/{id}")
    public String editReceptForm(@PathVariable Long id, Model model) {
        Recept recept = receptService.findById(id);
        model.addAttribute("recept", recept);
        return "szerkeszt";
    }

    @PostMapping("/szerkeszt/{id}")
    public String editRecept(@PathVariable Long id, @ModelAttribute Recept recept) {
        recept.setId(id);
        receptService.save(recept);
        return "redirect:/receptek";
    }
}
