package com.example.receptnyilvantartas.model;

public class Recept {

    private Long id;
    private String nev;
    private String leiras;

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

    @Override
    public String toString() {
        return "Recept{" +
                "id=" + id +
                ", nev='" + nev + '\'' +
                ", leiras='" + leiras + '\'' +
                '}';
    }
}
