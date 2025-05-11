package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Recept;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class MockReceptService implements ReceptService {

    private final List<Recept> receptTarolo = new ArrayList<>();
    private final AtomicLong idGenerator = new AtomicLong();

    @Override
    public List<Recept> findAll() {
        return new ArrayList<>(receptTarolo);
    }

    @Override
    public Recept findById(Long id) {
        return receptTarolo.stream()
                .filter(r -> r.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("Recept nem található"));
    }

    @Override
    public Recept save(Recept recept) {
        if (recept.getId() == null) {
            recept.setId(idGenerator.incrementAndGet());
        } else {
            deleteById(recept.getId()); // frissítés
        }
        receptTarolo.add(recept);
        return recept;
    }

    @Override
    public void deleteById(Long id) {
        receptTarolo.removeIf(r -> r.getId().equals(id));
    }
}
