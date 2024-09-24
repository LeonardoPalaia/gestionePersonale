package com.gestionePersonale.demo;

import java.time.LocalDateTime;

public class OrarioLavoro {

    LocalDateTime data_ora_inizio_turno, data_ora_fine_turno;
    int id_personale, id_sezione;

    public OrarioLavoro(LocalDateTime data_ora_inizio_turno, LocalDateTime data_ora_fine_turno, int id_personale, int id_sezione) {
        this.data_ora_inizio_turno = data_ora_inizio_turno;
        this.data_ora_fine_turno = data_ora_fine_turno;
        this.id_personale = id_personale;
        this.id_sezione = id_sezione;
    }


}
