package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.ImportanzaEconomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ImportanzaEconomicaRepository extends JpaRepository<ImportanzaEconomica, Long> {

    List<ImportanzaEconomica> findAllByAnno(Integer anno);

    List<ImportanzaEconomica> findAllByAnnoAndRegione(Integer anno, String regione);
}
