package com.gestionePersonale.demo.Dao;

import com.gestionePersonale.demo.model.OrarioLavoro;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OrarioLavoroDao extends JpaRepository<OrarioLavoro, Integer> {
    List<OrarioLavoro> findByPersonaleId(Integer personaleId); // Modificato da Long a Integer
}
