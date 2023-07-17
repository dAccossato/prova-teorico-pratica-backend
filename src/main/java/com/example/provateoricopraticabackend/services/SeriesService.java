package com.example.provateoricopraticabackend.services;

import com.example.provateoricopraticabackend.helpers.AreaGeografica;
import com.example.provateoricopraticabackend.output.*;
import com.example.provateoricopraticabackend.repositories.AndamentoOccupazioneRepository;
import com.example.provateoricopraticabackend.repositories.ImportanzaEconomicaRepository;
import com.example.provateoricopraticabackend.repositories.ProduttivitaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class SeriesService {

    @Autowired
    AndamentoOccupazioneRepository andamentoOccupazRepo;
    @Autowired
    ImportanzaEconomicaRepository importanzaEonomicaRepo;
    @Autowired
    ProduttivitaRepository produttivitaRepo;

    public ProduttivitaTotaleAreeResponse calcolaSerie1ProdTotaleAree(String anno) {

        //TODO iterazione per ricavare regioni da ricercare
        produttivitaRepo.findAllByAnnoAndRegione(Integer.valueOf(anno), "TODO");
        ProduttivitaTotaleAreeResponse response = new ProduttivitaTotaleAreeResponse();

        //TODO costruzione response e store nel db
        return response;
    }

    public ProduttivitaNazionaleResponse calcolaSerie2ProdTotaleNazionale(String anno) {
        ProduttivitaNazionaleResponse response = new ProduttivitaNazionaleResponse();
        produttivitaRepo.findAllByAnno(Integer.valueOf(anno));

        //TODO costruzione response e store nel db

        return response;
    }

    public MediaPercValAggiuntoAreeResponse calcolaSerie3MediaPercValAggiuntoAree(String anno) {
        MediaPercValAggiuntoAreeResponse response = new MediaPercValAggiuntoAreeResponse();

        //TODO iterazione per ricavare regioni da ricercare
        importanzaEonomicaRepo.findAllByAnnoAndRegione(Integer.valueOf(anno), "TODO");

        //TODO costruzione response e store nel db
        return response;
    }

    public MediaVariazionePercOccupNazionaleResponse calcolaSerie4MediaVariazionePercentualeOccupNazionale(String anno) {
        MediaVariazionePercOccupNazionaleResponse response = new MediaVariazionePercOccupNazionaleResponse();
        andamentoOccupazRepo.findAllByAnno(Integer.valueOf(anno));

        //TODO costruzione response e store nel db
        return response;
    }

    public MediaVariazionePercOccupAreeResponse calcolaSerie5MediaVariazionePercentualeOccupAree(String anno) {
        MediaVariazionePercOccupAreeResponse response = new MediaVariazionePercOccupAreeResponse();

        //TODO iterazione per ricavare regioni da ricercare
        andamentoOccupazRepo.findAllByAnnoAndRegione(Integer.valueOf(anno), "TODO");

        //TODO costruzione response e store nel db
        return response;
    }

    public AreaGeografica recuperaAreaGeografica(String regione){
        switch (regione){
            case "Piemonte", "Valle d'Aosta", "Lombardia" -> {
                return AreaGeografica.NORD_OVEST;
            }
            case "Trentino-Alto Adige", "Veneto", "Friuli-Venezia Giulia", "Emilia-Romagna" -> {
                return AreaGeografica.NORD_EST;
            }
            case "Toscana", "Umbria", "Marche", "Lazio", "Abruzzo" -> {
                return AreaGeografica.CENTRO;
            }
            case "Molise", "Campania", "Puglia", "Basilicata", "Calabria" -> {
                return AreaGeografica.SUD;
            }
            case "Sicilia", "Sardegna" -> {
                return AreaGeografica.ISOLE;
            }
        }
        return null;
    }
}
