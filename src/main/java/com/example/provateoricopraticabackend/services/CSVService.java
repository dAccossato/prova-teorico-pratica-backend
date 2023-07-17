package com.example.provateoricopraticabackend.services;

import com.example.provateoricopraticabackend.entities.AndamentoOccupazione;
import com.example.provateoricopraticabackend.entities.ImportanzaEconomica;
import com.example.provateoricopraticabackend.entities.Produttivita;
import com.example.provateoricopraticabackend.helpers.AndamentoOccupazionePojo;
import com.example.provateoricopraticabackend.helpers.ImportanzaEconomicaPojo;
import com.example.provateoricopraticabackend.helpers.ProduttivitaPojo;
import com.example.provateoricopraticabackend.repositories.AndamentoOccupazioneRepository;
import com.example.provateoricopraticabackend.repositories.ImportanzaEconomicaRepository;
import com.example.provateoricopraticabackend.repositories.ProduttivitaRepository;
import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;

import java.io.File;
import java.sql.SQLIntegrityConstraintViolationException;
import java.util.Collections;
import java.util.List;
import java.util.NoSuchElementException;

@Service
public class CSVService {

    @Autowired
    AndamentoOccupazioneRepository andamentoOccupazRepo;
    @Autowired
    ImportanzaEconomicaRepository importanzaEonomicaRepo;
    @Autowired
    ProduttivitaRepository produttivitaRepo;

    public <T> List<T> loadObjectList(Class<T> type, String fileName) {
        try {
            CsvSchema bootstrapSchema = CsvSchema.emptySchema().withColumnSeparator(';').withHeader();
            CsvMapper mapper = new CsvMapper();

            if (type.equals(AndamentoOccupazione.class)) {
                mapper.addMixIn(AndamentoOccupazione.class, AndamentoOccupazionePojo.class);
            } else if (type.equals(ImportanzaEconomica.class)) {
                mapper.addMixIn(ImportanzaEconomica.class, ImportanzaEconomicaPojo.class);
            }
            else if (type.equals(Produttivita.class)) {
                mapper.addMixIn(Produttivita.class, ProduttivitaPojo.class);
            }

            File file = new ClassPathResource(fileName).getFile();
            MappingIterator<T> readValues =
                    mapper.reader(type).with(bootstrapSchema).readValues(file);
            return readValues.readAll();
        } catch (Exception e) {
            return Collections.emptyList();
        }
    }


    public Boolean caricaCsv(String dataType) throws SQLIntegrityConstraintViolationException {
        switch (dataType) {
            case "andOccup" -> loadAndamentoOccupazione();
            case "impEconom" -> loadImportanzaeconomica();
            case "produttivita" -> loadProduttivita();
            default -> throw new NoSuchElementException();
        }

        return true;

    }

    private void loadAndamentoOccupazione() throws SQLIntegrityConstraintViolationException {
        List<AndamentoOccupazione> andamentoOccupazioneList = loadObjectList(AndamentoOccupazione.class, "static/Andamento-occupazione-del-settore-della-pesca-per-regione.csv");
        andamentoOccupazRepo.saveAll(andamentoOccupazioneList);
    }

    private void loadImportanzaeconomica() throws SQLIntegrityConstraintViolationException {
        List<ImportanzaEconomica> importanzaEconomicaList = loadObjectList(ImportanzaEconomica.class, "static/Importanza-economica-del-settore-della-pesca-per-regione.csv");
        importanzaEonomicaRepo.saveAll(importanzaEconomicaList);
    }

    private void loadProduttivita() throws SQLIntegrityConstraintViolationException  {
        List<Produttivita> produttivitaList = loadObjectList(Produttivita.class, "static/Produttivita-del-settore-della-pesca-per-regione.csv");
        produttivitaRepo.saveAll(produttivitaList);
    }

    public Boolean caricaTutti() throws SQLIntegrityConstraintViolationException {
        loadAndamentoOccupazione();
        loadImportanzaeconomica();
        loadProduttivita();
        return true;
    }
}
