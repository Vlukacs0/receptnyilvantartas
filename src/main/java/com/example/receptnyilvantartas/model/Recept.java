package com.example.receptnyilvantartas.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Recept {
    private Long id;
    private String nev;
    private String leiras;
}
