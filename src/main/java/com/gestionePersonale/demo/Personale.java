package com.gestionePersonale.demo;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

public class Personale {

    @NotNull
    @Size(min = 1)
    private String id;
    @NotNull
    private String nome, cognome;
    @NotNull
    @Email
    private String email;
    @NotNull
    @Size(min = 8, message = "La password deve essere almeno di 8 caratteri")
    private String passoword;
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

    public @NotNull @Email String getEmail() {
        return email;
    }

    public void setEmail(@NotNull @Email String email) {
        this.email = email;
    }

    public @NotNull @Size(min = 8, message = "La password deve essere almeno di 8 caratteri") String getPassoword() {
        return passoword;
    }

    public void setPassoword(@NotNull @Size(min = 8, message = "La password deve essere almeno di 8 caratteri") String passoword) {
        this.passoword = passoword;
    }

    @NotNull
    public int getRuolo() {
        return ruolo;
    }

    public void setRuolo(@NotNull int ruolo) {
        this.ruolo = ruolo;
    }

}
