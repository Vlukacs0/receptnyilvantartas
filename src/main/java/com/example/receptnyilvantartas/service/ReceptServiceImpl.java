package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Recept;
import com.example.receptnyilvantartas.repository.ReceptRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReceptServiceImpl implements ReceptService {

    private final ReceptRepository receptRepository;

    public ReceptServiceImpl(ReceptRepository receptRepository) {
        this.receptRepository = receptRepository;
    }

    @Override
    public List<Recept> findAll() {
        return receptRepository.findAll();
    }

    @Override
    public Recept findById(Long id) {
        return receptRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Recept nem található"));
    }

    @Override
    public Recept save(Recept recept) {
        return receptRepository.save(recept);
    }

    @Override
    public void deleteById(Long id) {
        receptRepository.deleteById(id);
    }
}
