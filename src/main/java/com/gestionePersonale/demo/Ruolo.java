package com.gestionePersonale.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ruolo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private int id;
    private String descrizione;

    public Ruolo(int id, String descrizione) {
        this.id = id;
        this.descrizione = descrizione;
    }

    public Ruolo() {

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
