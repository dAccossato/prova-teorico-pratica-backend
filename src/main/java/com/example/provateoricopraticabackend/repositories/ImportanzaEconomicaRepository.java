package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.ImportanzaEconomica;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ImportanzaEconomicaRepository extends JpaRepository<ImportanzaEconomica, Long> {
}
