package com.gestionePersonale.demo;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Personale extends Credenziali {

    @NotNull
    @Size(min = 1)
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private String id;
    @NotNull
    private String nome, cognome;

    private int idRuolo;

    public @NotNull @Size(min = 1) String getId() {
        return id;
    }

    public void setId(@NotNull @Size(min = 1) String id) {
        this.id = id;
    }

    public @NotNull String getNome() {
        return nome;
    }

    public void setNome(@NotNull String nome) {
        this.nome = nome;
    }

    public @NotNull String getCognome() {
        return cognome;
    }

    public void setCognome(@NotNull String cognome) {
        this.cognome = cognome;
    }


}
