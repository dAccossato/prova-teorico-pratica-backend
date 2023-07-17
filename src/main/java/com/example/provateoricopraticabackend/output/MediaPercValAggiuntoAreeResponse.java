package com.example.provateoricopraticabackend.output;

import lombok.Data;

@Data
public class MediaPercValAggiuntoAreeResponse {
    private Long mediaPercNordOvest;
    private Long mediaPercNordEst;
    private Long mediaPercCentro;
    private Long mediaPercSud;
    private Long mediaPercIsole;
}
