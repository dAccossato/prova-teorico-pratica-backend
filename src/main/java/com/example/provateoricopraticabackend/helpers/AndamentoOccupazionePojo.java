package com.example.provateoricopraticabackend.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class AndamentoOccupazionePojo {
    @JsonProperty("Anno")
    abstract Integer getAnno();

    @JsonProperty("Regione")
    abstract String getRegione();

    @JsonProperty("Variazione percentuale unità di lavoro della pesca")
    abstract String getVarPerc();
}
