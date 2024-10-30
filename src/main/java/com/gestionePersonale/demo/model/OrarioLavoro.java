package com.gestionePersonale.demo.model;

import jakarta.persistence.*;

import java.time.LocalDateTime;

@Entity
public class OrarioLavoro {

    @Id
    @GeneratedValue(strategy= GenerationType.AUTO)
    Integer id;

    LocalDateTime data_ora_inizio_turno, data_ora_fine_turno;
    int id_personale, id_sezione;

    public OrarioLavoro() {

    }

    public OrarioLavoro(LocalDateTime data_ora_inizio_turno, LocalDateTime data_ora_fine_turno, int id_personale, int id_sezione, Integer id) {
        this.data_ora_inizio_turno = data_ora_inizio_turno;
        this.data_ora_fine_turno = data_ora_fine_turno;
        this.id_personale = id_personale;
        this.id_sezione = id_sezione;
        this.id=id;
    }

    @ManyToOne
    Sezione sezione;

    @ManyToOne
    Personale personale;

    public LocalDateTime getData_ora_inizio_turno() {
        return data_ora_inizio_turno;
    }

    public void setData_ora_inizio_turno(LocalDateTime data_ora_inizio_turno) {
        this.data_ora_inizio_turno = data_ora_inizio_turno;
    }

    public LocalDateTime getData_ora_fine_turno() {
        return data_ora_fine_turno;
    }

    public void setData_ora_fine_turno(LocalDateTime data_ora_fine_turno) {
        this.data_ora_fine_turno = data_ora_fine_turno;
    }

    public int getId_personale() {
        return id_personale;
    }

    public void setId_personale(int id_personale) {
        this.id_personale = id_personale;
    }

    public int getId_sezione() {
        return id_sezione;
    }

    public void setId_sezione(int id_sezione) {
        this.id_sezione = id_sezione;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
