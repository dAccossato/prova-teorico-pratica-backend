package com.example.provateoricopraticabackend.output;

import lombok.Data;

@Data
public class MediaVariazionePercOccupAreeResponse {
    private Long mediaVariazPerOccupNordOvest;
    private Long mediaVariazPerOccupNordEst;
    private Long mediaVariazPerOccupCentro;
    private Long mediaVariazPerOccupSud;
    private Long mediaVariazPerOccupIsole;
}
