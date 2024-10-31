package com.gestionePersonale.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Personale extends Credenziali {

    @NotNull
    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;
    @NotNull
    private String nome, cognome;

    @ManyToOne
    @JoinColumn(name = "ruolo_id")
    private Ruolo ruolo;

    public @NotNull Integer getId() {
        return id;
    }

    public void setId(@NotNull Integer id) {
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

    public void setRuolo(@NotNull Ruolo ruolo) {
        this.ruolo = ruolo;
    }

    public @NotNull Ruolo getRuolo() {
        return ruolo;
    }
}
