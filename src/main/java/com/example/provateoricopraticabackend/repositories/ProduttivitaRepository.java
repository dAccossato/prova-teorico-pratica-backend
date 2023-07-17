package com.example.provateoricopraticabackend.repositories;

import com.example.provateoricopraticabackend.entities.Produttivita;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProduttivitaRepository extends JpaRepository<Produttivita, Long> {
}
