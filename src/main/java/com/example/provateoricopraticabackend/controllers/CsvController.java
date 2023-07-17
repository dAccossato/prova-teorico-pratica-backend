package com.example.provateoricopraticabackend.controllers;

import com.example.provateoricopraticabackend.output.BaseOutRes;
import com.example.provateoricopraticabackend.services.CSVService;
import io.swagger.v3.oas.annotations.Operation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.sql.SQLIntegrityConstraintViolationException;

@RestController
@RequestMapping("csv")
public class CsvController {

    @Autowired
    CSVService csvService;

    @GetMapping()
    @Operation(summary = "Effettua il caricamento dei dati da CSV", description = "Effettua il caricamento dei dati da CSV. In assenza di informazione su quale csv caricare, vengono caricati tutti")
    public ResponseEntity<BaseOutRes> caricaCsv(
            @RequestParam(value = "dataSet", required = false) String dataSet) {
        BaseOutRes res = new BaseOutRes();

        try {
            Boolean serviceRes;
            if (dataSet != null) {
                serviceRes = csvService.caricaCsv(dataSet);
            } else {
                serviceRes = csvService.caricaTutti();
            }

            res.setData(String.valueOf(serviceRes));
            res.setDescr("Elementi letti dal csv e caricati correttamente sul DB");

        } catch (Exception e) {
            res.setData(String.valueOf(false));
            res.setDescr(e.getMessage());
            return new ResponseEntity<>(res, HttpStatus.BAD_REQUEST);
        }


        return new ResponseEntity<>(res, HttpStatus.OK);
    }

}
