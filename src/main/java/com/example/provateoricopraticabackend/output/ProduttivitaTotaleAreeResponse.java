package com.example.provateoricopraticabackend.output;

import lombok.Data;

@Data
public class ProduttivitaTotaleAreeResponse {
    private Long prodTotNordOvest;
    private Long prodTotNordEst;
    private Long prodTotCentro;
    private Long prodTotaleSud;
    private Long prodTotaleIsole;
}
