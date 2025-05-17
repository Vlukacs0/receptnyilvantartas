package com.example.receptnyilvantartas.model;

import jakarta.persistence.*;

@Entity
public class Ertekeles {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private int pontszam;

    private String megjegyzes;
    @ManyToOne
    @JoinColumn(name = "recept_id")
    private Recept recept;
    @ManyToOne
    @JoinColumn(name = "felhasznalo_id")
    private Felhasznalo felhasznalo;
    public Ertekeles() {
    }
    public Ertekeles(int pontszam, String megjegyzes, Recept recept, Felhasznalo felhasznalo) {
        this.pontszam = pontszam;
        this.megjegyzes = megjegyzes;
        this.recept = recept;
        this.felhasznalo = felhasznalo;
    }
    public Long getId() {
        return id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public int getPontszam() {
        return pontszam;
    }
    public void setPontszam(int pontszam) {
        this.pontszam = pontszam;
    }
    public String getMegjegyzes() {
        return megjegyzes;
    }
    public void setMegjegyzes(String megjegyzes) {
        this.megjegyzes = megjegyzes;
    }
    public Recept getRecept() {
        return recept;
    }
    public void setRecept(Recept recept) {
        this.recept = recept;
    }
    public Felhasznalo getFelhasznalo() {
        return felhasznalo;
    }
    public void setFelhasznalo(Felhasznalo felhasznalo) {
        this.felhasznalo = felhasznalo;
    }
}
