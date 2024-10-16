package com.gestionePersonale.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class PersonaleRuolo {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    int id;
    int idPersonale;
    int idRUolo;
}
