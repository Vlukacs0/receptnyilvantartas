package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Felhasznalo;
import com.example.receptnyilvantartas.repository.FelhasznaloRepository;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class FelhasznaloServiceImpl implements FelhasznaloService {
    private final FelhasznaloRepository repository;
    public FelhasznaloServiceImpl(FelhasznaloRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Felhasznalo> findAll() {
        return repository.findAll();
    }
    @Override
    public Felhasznalo findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Felhasználó nem található"));
    }
    @Override
    public Felhasznalo save(Felhasznalo felhasznalo) {
        return repository.save(felhasznalo);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
