package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Ertekeles;
import com.example.receptnyilvantartas.repository.ErtekelesRepository;
import org.springframework.stereotype.Service;
import java.util.List;
@Service
public class ErtekelesServiceImpl implements ErtekelesService {
    private final ErtekelesRepository repository;
    public ErtekelesServiceImpl(ErtekelesRepository repository) {
        this.repository = repository;
    }
    @Override
    public List<Ertekeles> findAll()
    {
        return repository.findAll();
    }
    @Override
    public Ertekeles findById(Long id) {
        return repository.findById(id).orElseThrow(() -> new RuntimeException("Értékelés nem található"));
    }
    @Override
    public Ertekeles save(Ertekeles ertekeles)
    {
        return repository.save(ertekeles);
    }
    @Override
    public void deleteById(Long id) {
        repository.deleteById(id);
    }
}
