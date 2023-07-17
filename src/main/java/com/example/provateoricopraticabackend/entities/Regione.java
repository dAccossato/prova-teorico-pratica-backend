package com.example.provateoricopraticabackend.entities;

import com.example.provateoricopraticabackend.helpers.AreaGeografica;
import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.*;


@Entity
@Table(name = "regione")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class Regione {
    @Id
    private String nome;
    private AreaGeografica areaGeografica;
}
