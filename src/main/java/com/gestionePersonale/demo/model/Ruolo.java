package com.gestionePersonale.demo.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Ruolo {
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    private String descrizione;

    public Ruolo(String descrizione) {
        this.descrizione = descrizione;
    }

    public Ruolo() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getDescrizione() {
        return descrizione;
    }

    public void setDescrizione(String descrizione) {
        this.descrizione = descrizione;
    }
}
