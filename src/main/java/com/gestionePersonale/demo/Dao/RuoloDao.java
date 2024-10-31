package com.gestionePersonale.demo.Dao;

import com.gestionePersonale.demo.model.Ruolo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RuoloDao extends JpaRepository <Ruolo, Integer> {
}
