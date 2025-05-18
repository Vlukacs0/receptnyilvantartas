package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Recept;
import com.example.receptnyilvantartas.repository.ReceptRepository;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class ReceptServiceImplTest
{

    @Autowired
    private ReceptService receptService;

    @Autowired
    private ReceptRepository receptRepository;

    @Test
    void testSave() {
        Recept recept = new Recept(null, "Gulyás", "Leves");
        Recept mentett = receptService.save(recept);
        assertNotNull(mentett.getId());
        assertEquals("Gulyás", mentett.getNev());
    }
    @Test
    void testFindAll() {
        receptService.save(new Recept(null, "Lecsó", "Paradicsom,Paprika"));
        receptService.save(new Recept(null, "Rántotta", "Tojás"));
        List<Recept> receptek = receptService.findAll();
        assertTrue(receptek.size() >= 2);
    }
    @Test
    void testFindById()
    {
        Recept mentett = receptService.save(new Recept(null, "Palacsinta", "Lekváros"));
        Recept megtalalt = receptService.findById(mentett.getId());
        assertEquals("Palacsinta", megtalalt.getNev());
    }

    @Test
    void testDeleteById()
    {
        Recept mentett = receptService.save(new Recept(null, "Túrós csusza", "Túrós"));
        receptService.deleteById(mentett.getId());
        assertFalse(receptRepository.findById(mentett.getId()).isPresent());
    }
}
