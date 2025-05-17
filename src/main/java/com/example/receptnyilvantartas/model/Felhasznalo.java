package com.example.receptnyilvantartas.model;

import jakarta.persistence.*;
import java.util.List;

@Entity
public class Felhasznalo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nev;
    private String email;
    @OneToMany(mappedBy = "felhasznalo", cascade = CascadeType.ALL)
    private List<Ertekeles> ertekelesek;
    public Felhasznalo() {
    }
    public Felhasznalo(String nev, String email) {
        this.nev = nev;
        this.email = email;
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
    public String getEmail() {
        return email;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public List<Ertekeles> getErtekelesek() {
        return ertekelesek;
    }
    public void setErtekelesek(List<Ertekeles> ertekelesek) {
        this.ertekelesek = ertekelesek;
    }
}