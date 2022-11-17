package com.example.tp.controllers;


import com.example.tp.entities.Facture;
import com.example.tp.services.IFactureService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


@RestController
public class FactureController {
    @Autowired
    IFactureService iFactureService;

    @GetMapping("/retrieveAllFactures")
    public List<Facture> retrieveAllFactures(){
        return iFactureService.retrieveAllFactures();
    }

    @PutMapping("/cancelFacture")
    public void cancelFacture(Long id){
        iFactureService.cancelFacture(id);
    }

    @GetMapping("/retrieveFacture")
    public Facture retrieveFacture(Long id){
        return iFactureService.retrieveFacture(id);
    }
}
