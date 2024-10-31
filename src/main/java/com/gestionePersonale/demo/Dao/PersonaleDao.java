package com.gestionePersonale.demo.Dao;

import com.gestionePersonale.demo.model.Personale;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonaleDao extends JpaRepository<Personale, Integer> {

    Personale findByEmail(String email);
}
