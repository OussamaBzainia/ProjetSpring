package com.example.tp.services;

import com.example.tp.entities.Facture;
import com.example.tp.repositories.IFactureRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class IFactureServiceIMP implements IFactureService{

    @Autowired
    IFactureRepository iFactureRepository;

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
}
