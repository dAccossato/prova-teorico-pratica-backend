package com.example.provateoricopraticabackend.controllers;

import com.example.provateoricopraticabackend.services.SeriesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("series")
public class SeriesController {

    @Autowired
    SeriesService serieService;

/*    @GetMapping
    public ResponseEntity<> retrieveAllSeries(){

    }*/

}
