package com.example.provateoricopraticabackend.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ImportanzaEconomicaPojo {
    @JsonProperty("Anno")
    abstract Integer getAnno();

    @JsonProperty("Regione")
    abstract String getRegione();

    @JsonProperty("Percentuale valore aggiunto pesca-piscicoltura-servizi")
    abstract String getPercValoreAggiunto();
}
