package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.AndamentoOccupazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AndamentoOccupazioneRepository extends JpaRepository<AndamentoOccupazione, Long> {
    List<AndamentoOccupazione> findAllByAnno(Integer anno);

    List<AndamentoOccupazione> findAllByAnnoAndRegione(Integer anno, String regione);
}
