package com.example.receptnyilvantartas.service;
import com.example.receptnyilvantartas.model.Recept;
import java.util.List;
public interface ReceptService {
    List<Recept> findAll();
    Recept findById(Long id);
    Recept save(Recept recept);
    void deleteById(Long id);
}
