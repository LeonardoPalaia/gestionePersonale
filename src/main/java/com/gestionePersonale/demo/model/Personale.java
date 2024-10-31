package com.gestionePersonale.demo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;

@Entity
public class Personale extends Credenziali {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    private Integer id;

    @NotBlank(message = "Il nome non può essere vuoto")
    @Size(min = 1, max = 50, message = "Il nome deve essere compreso tra 1 e 50 caratteri")
    private String nome;

    @NotBlank(message = "Il cognome non può essere vuoto")
    @Size(min = 1, max = 50, message = "Il cognome deve essere compreso tra 1 e 50 caratteri")
    private String cognome;

    @NotNull(message = "Il ruolo non può essere nullo")
    @ManyToOne
    @JoinColumn(name = "ruolo_id")
    private Ruolo ruolo;

    // Getter e Setter

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCognome() {
        return cognome;
    }

    public void setCognome(String cognome) {
        this.cognome = cognome;
    }

    public Ruolo getRuolo() {
        return ruolo;
    }

    public void setRuolo(Ruolo ruolo) {
        this.ruolo = ruolo;
    }
}
