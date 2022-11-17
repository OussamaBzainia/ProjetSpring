package com.example.tp.controllers;


import com.example.tp.entities.Produit;
import com.example.tp.services.IProduitService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ProduitController {
    @Autowired
    IProduitService iProduitService;

    @GetMapping("/retrieveAllProduits")
    public List<Produit> retrieveAllProduits(){
        return iProduitService.retrieveAllProduits();
    }
    @PostMapping("/addProduit/{idRayon}/{idStock}")
    public Produit addProduit(@RequestBody  Produit p, @PathVariable Long idRayon,@PathVariable Long idStock){
        return iProduitService.addProduit(p,idRayon,idStock);
    }

    @GetMapping("/retrieveProduit/{id}")
    public Produit retrieveProduit(@PathVariable Long id){
        return iProduitService.retrieveProduit(id);
    }

    @PutMapping("/assignProduitToStock/{idProduit}/{idStock}")
    public void assignProduitToStock(@PathVariable Long idProduit,@PathVariable Long idStock){
        iProduitService.assignProduitToStock(idProduit,idStock);
    }
}
