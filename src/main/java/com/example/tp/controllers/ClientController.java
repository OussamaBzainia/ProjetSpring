package com.example.tp.controllers;


import com.example.tp.entities.Client;
import com.example.tp.entities.Facture;
import com.example.tp.repositories.IClientRepository;
import com.example.tp.services.IClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    IClientService  iClientService;

    @GetMapping("/retrieveAllClients")
    public List<Client> retrieveAllClients(){
       return iClientService.retrieveAllClients();
    }

    @PostMapping("/addClient")
    public Client addClient(@RequestBody Client c){
        return iClientService.addClient(c);
    }


    @DeleteMapping("deleteClient/{id}")
    public void deleteClient(@PathVariable Long id){
        iClientService.deleteClient(id);
    }

    @PutMapping("/updateClient")
    public Client updateClient(@RequestBody Client c){
       return iClientService.updateClient(c);
    }

    @GetMapping("/retrieveClient/{id}")
    public Client retrieveClient(@PathVariable Long id){
        return iClientService.retrieveClient(id);
    }

    @GetMapping("/getFacturesByClient/{idClient}")
    public List<Facture> getFacturesByClient(@PathVariable Long idClient){

        return iClientService.getFacturesByClient(idClient);
    }

    @GetMapping ("/{categorieClient}/{startDate}/{endDate}")
    public float getChiffreAffaireParCategorieClient(@PathVariable(value = "categorieClient") CategorieClient categorieClient,@PathVariable(value = "startDate") Date startDate,@PathVariable(value = "endDate") Date endDate)
    {
        return iClientService.getChiffreAffaireParCategorieClient(categorieClient,startDate,endDate);
    }
}

