package com.example.receptnyilvantartas.service;
import com.example.receptnyilvantartas.model.Felhasznalo;
import java.util.List;
public interface FelhasznaloService {
    List<Felhasznalo> findAll();
    Felhasznalo findById(Long id);
    Felhasznalo save(Felhasznalo felhasznalo);
    void deleteById(Long id);
}
