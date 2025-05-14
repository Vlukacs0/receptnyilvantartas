package com.example.receptnyilvantartas.repository;

import com.example.receptnyilvantartas.model.Recept;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ReceptRepository extends JpaRepository<Recept, Long> {
}
