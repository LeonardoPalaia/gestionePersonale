package com.gestionePersonale.demo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class OrarioLavoro {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Integer id;

    private LocalDateTime dataOraInizioTurno;
    private LocalDateTime dataOraFineTurno;

    @ManyToOne
    @JoinColumn(name = "id_personale", referencedColumnName = "id")
    private Personale personale;

    @ManyToOne
    @JoinColumn(name = "id_sezione", referencedColumnName = "id")
    private Sezione sezione;

    public OrarioLavoro() {}

    public OrarioLavoro(LocalDateTime dataOraInizioTurno, LocalDateTime dataOraFineTurno, Personale personale, Sezione sezione) {
        this.dataOraInizioTurno = dataOraInizioTurno;
        this.dataOraFineTurno = dataOraFineTurno;
        this.personale = personale;
        this.sezione = sezione;
    }

    // Getters e Setters
    public LocalDateTime getDataOraInizioTurno() {
        return dataOraInizioTurno;
    }

    public void setDataOraInizioTurno(LocalDateTime dataOraInizioTurno) {
        this.dataOraInizioTurno = dataOraInizioTurno;
    }

    public LocalDateTime getDataOraFineTurno() {
        return dataOraFineTurno;
    }

    public void setDataOraFineTurno(LocalDateTime dataOraFineTurno) {
        this.dataOraFineTurno = dataOraFineTurno;
    }

    public Personale getPersonale() {
        return personale;
    }

    public void setPersonale(Personale personale) {
        this.personale = personale;
    }

    public Sezione getSezione() {
        return sezione;
    }

    public void setSezione(Sezione sezione) {
        this.sezione = sezione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}