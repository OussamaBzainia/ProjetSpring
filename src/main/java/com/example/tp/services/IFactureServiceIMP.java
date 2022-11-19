package com.example.tp.services;

import com.example.tp.entities.Facture;
import com.example.tp.entities.Client;
import com.example.tp.repositories.IFactureRepository;
import com.example.tp.repositories.IClientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFactureServiceIMP implements IFactureService{

    @Autowired
    IFactureRepository iFactureRepository;
    
    @Autowired
    IClientRepository iClientRepository;



    @Override
    public List<Facture> retrieveAllFactures() {
        return iFactureRepository.findAll();
    }

    @Override
    public void cancelFacture(Long id) {
       Facture f= iFactureRepository.findById(id).orElse(null);
       f.setActive(false);
    }

    @Override
    public Facture retrieveFacture(Long id) {
        return iFactureRepository.findById(id).orElse(null);
    }

    @Override
    public List<Facture> getFacturesByClient(Long idClient) {
        Client c = iClientRepository.findById(idClient).orElse(null);
        if(c != null){
            return c.getFactures();
        }
        return null;
    }

    @Override
    public Facture addFacture(Facture f, Long idClient) {
        Client client = iClientRepository.findById(idClient).orElse(null);
        if(client != null)
            f.setClient(client);
        return null;
    }
}
