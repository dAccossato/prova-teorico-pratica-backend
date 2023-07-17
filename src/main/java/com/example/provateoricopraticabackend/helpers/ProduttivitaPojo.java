package com.example.provateoricopraticabackend.helpers;

import com.fasterxml.jackson.annotation.JsonProperty;

public abstract class ProduttivitaPojo {
    @JsonProperty("Anno")
    abstract Integer getAnno();

    @JsonProperty("Regione")
    abstract String getRegione();

    @JsonProperty("Produttività in migliaia di euro")
    abstract String getProduttivita();
}
