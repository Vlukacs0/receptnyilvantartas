package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Ertekeles;
import java.util.List;
public interface ErtekelesService {
    List<Ertekeles> findAll();
    Ertekeles findById(Long id);
    Ertekeles save(Ertekeles ertekeles);
    void deleteById(Long id);
}
