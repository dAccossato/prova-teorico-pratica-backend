package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.Produttivita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProduttivitaRepository extends JpaRepository<Produttivita, Long> {
    List<Produttivita> findAllByAnno(Integer anno);

    List<Produttivita> findAllByAnnoAndRegione(Integer anno, String regione);
}
