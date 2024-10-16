package com.gestionePersonale.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Personale extends Credenziali {

    @NotNull
    @Size(min = 1)
    private String id;
    @NotNull
    private String nome, cognome;

    @NotNull
    private int ruolo;

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


    @NotNull
    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(@NotNull int ruolo) {
        this.ruolo = ruolo;
    }

}
