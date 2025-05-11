package com.example.receptnyilvantartas.controller;

import com.example.receptnyilvantartas.model.Recept;
import com.example.receptnyilvantartas.service.ReceptService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/receptek")
public class ReceptController {

    private final ReceptService receptService;

    public ReceptController(ReceptService receptService) {
        this.receptService = receptService;
    }

    @GetMapping
    public List<Recept> getAllReceptek() {
        return receptService.findAll();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Recept> getReceptById(@PathVariable Long id) {
        try {
            return ResponseEntity.ok(receptService.findById(id));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public Recept createRecept(@RequestBody Recept recept) {
        return receptService.save(recept);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Recept> updateRecept(@PathVariable Long id, @RequestBody Recept recept) {
        try {
            recept.setId(id);
            return ResponseEntity.ok(receptService.save(recept));
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRecept(@PathVariable Long id) {
        try {
            receptService.deleteById(id);
            return ResponseEntity.noContent().build();
        } catch (RuntimeException e) {
            return ResponseEntity.notFound().build();
        }
    }
}
