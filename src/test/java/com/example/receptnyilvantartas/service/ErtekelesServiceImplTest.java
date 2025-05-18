package com.example.receptnyilvantartas.service;

import com.example.receptnyilvantartas.model.Ertekeles;
import com.example.receptnyilvantartas.repository.ErtekelesRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;
import java.util.Optional;

import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;

class ErtekelesServiceImplTest {

    private ErtekelesRepository repository;
    private ErtekelesServiceImpl service;

    @BeforeEach
    void setUp() {
        repository = Mockito.mock(ErtekelesRepository.class);
        service = new ErtekelesServiceImpl(repository);
    }

    @Test
    void testFindAll() {
        when(repository.findAll()).thenReturn(List.of(new Ertekeles(), new Ertekeles()));

        List<Ertekeles> eredmeny = service.findAll();

        assertEquals(2, eredmeny.size());
        verify(repository, times(1)).findAll();
    }



    @Test
    void testSave() {
        Ertekeles ertekeles = new Ertekeles();
        when(repository.save(ertekeles)).thenReturn(ertekeles);

        Ertekeles eredmeny = service.save(ertekeles);

        assertNotNull(eredmeny);
        verify(repository, times(1)).save(ertekeles);
    }

    @Test
    void testDeleteById() {
        doNothing().when(repository).deleteById(1L);

        service.deleteById(1L);

        verify(repository, times(1)).deleteById(1L);
    }
}
