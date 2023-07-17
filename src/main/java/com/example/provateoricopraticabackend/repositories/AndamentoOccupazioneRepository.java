package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.AndamentoOccupazione;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AndamentoOccupazioneRepository extends JpaRepository<AndamentoOccupazione, Long> {
}
