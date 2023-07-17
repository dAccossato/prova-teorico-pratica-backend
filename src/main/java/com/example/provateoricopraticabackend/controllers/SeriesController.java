package com.example.provateoricopraticabackend.controllers;

import com.example.provateoricopraticabackend.output.*;
import com.example.provateoricopraticabackend.repositories.AndamentoOccupazioneRepository;
import com.example.provateoricopraticabackend.repositories.ImportanzaEconomicaRepository;
import com.example.provateoricopraticabackend.services.SeriesService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("serie")
public class SeriesController {

    @Autowired
    SeriesService serieService;

    @GetMapping("/calcolaSerie1")
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<ProduttivitaTotaleAreeResponse> serie1(
            @RequestParam(value = "anno") String anno) {
        ProduttivitaTotaleAreeResponse res = new ProduttivitaTotaleAreeResponse();
        if (anno != null) {
            res = serieService.calcolaSerie1ProdTotaleAree(anno);
        } else {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/calcolaSerie2")
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<ProduttivitaNazionaleResponse> serie2(
            @RequestParam(value = "anno") String anno) {
        ProduttivitaNazionaleResponse res = new ProduttivitaNazionaleResponse();
        if (anno != null) {
            res = serieService.calcolaSerie2ProdTotaleNazionale(anno);
        } else {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/calcolaSerie3")
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<MediaPercValAggiuntoAreeResponse> serie3(
            @RequestParam(value = "anno") String anno) {
        MediaPercValAggiuntoAreeResponse res = new MediaPercValAggiuntoAreeResponse();
        if (anno != null) {
            res = serieService.calcolaSerie3MediaPercValAggiuntoAree(anno);
        } else {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/calcolaSerie4")
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<MediaVariazionePercOccupNazionaleResponse> serie4(
            @RequestParam(value = "anno") String anno) {
        MediaVariazionePercOccupNazionaleResponse res = new MediaVariazionePercOccupNazionaleResponse();
        if (anno != null) {
            res = serieService.calcolaSerie4MediaVariazionePercentualeOccupNazionale(anno);
        } else {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

    @GetMapping("/calcolaSerie5")
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<MediaVariazionePercOccupAreeResponse> serie5(
            @RequestParam(value = "anno") String anno) {
        MediaVariazionePercOccupAreeResponse res = new MediaVariazionePercOccupAreeResponse();
        if (anno != null) {
            res = serieService.calcolaSerie5MediaVariazionePercentualeOccupAree(anno);
        } else {
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }

        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
