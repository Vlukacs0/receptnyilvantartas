package com.example.receptnyilvantartas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Recept {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String nev;

    private String leiras;

    @OneToMany(mappedBy = "recept", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Ertekeles> ertekelesek;

    public Recept() {
    }

    public Recept(Long id, String nev, String leiras) {
        this.id = id;
        this.nev = nev;
        this.leiras = leiras;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNev() {
        return nev;
    }

    public void setNev(String nev) {
        this.nev = nev;
    }

    public String getLeiras() {
        return leiras;
    }

    public void setLeiras(String leiras) {
        this.leiras = leiras;
    }

    public List<Ertekeles> getErtekelesek() {
        return ertekelesek;
    }

    public void setErtekelesek(List<Ertekeles> ertekelesek) {
        this.ertekelesek = ertekelesek;
    }

    @Override
    public String toString() {
        return "Recept{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", leiras='" + leiras + '\'' +
                '}';
    }
}
