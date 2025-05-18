package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Felhasznalo;
import com.example.receptnyilvantartas.repository.FelhasznaloRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class FelhasznaloServiceImplTest {

    private FelhasznaloRepository repository;
    private FelhasznaloServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(FelhasznaloRepository.class);
        service = new FelhasznaloServiceImpl(repository);
    }
    @Test
    void testFindAll()
    {
        when(repository.findAll()).thenReturn(List.of(new Felhasznalo(), new Felhasznalo()));

        List<Felhasznalo> eredmeny = service.findAll();

        assertEquals(2, eredmeny.size());
        verify(repository, times(1)).findAll();
    }



    @Test
    void testSave() {
        Felhasznalo felhasznalo = new Felhasznalo();
        when(repository.save(felhasznalo)).thenReturn(felhasznalo);

        Felhasznalo eredmeny = service.save(felhasznalo);

        assertNotNull(eredmeny);
        verify(repository, times(1)).save(felhasznalo);
    }



    @Test
    void testDeleteById() {
        doNothing().when(repository).deleteById(1L);

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
