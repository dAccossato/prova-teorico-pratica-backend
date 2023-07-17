package com.example.provateoricopraticabackend.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "produttivita", uniqueConstraints={
        @UniqueConstraint(columnNames = {"regione", "anno"})})
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class Produttivita {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private Integer anno;

    @Column
    private String regione;

    @Column
    private Double produttivita;
}
