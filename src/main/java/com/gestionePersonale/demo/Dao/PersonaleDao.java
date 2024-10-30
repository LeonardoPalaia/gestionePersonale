package com.gestionePersonale.demo.Dao;

import com.gestionePersonale.demo.model.Personale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaleDao extends JpaRepository<Personale, Integer> {
    // Qui puoi aggiungere metodi di query personalizzati se necessario
    Personale findByEmail(String email); // Un esempio di query personalizzata
}
