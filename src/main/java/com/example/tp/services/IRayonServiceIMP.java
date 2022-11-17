package com.example.tp.services;


import com.example.tp.entities.Rayon;
import com.example.tp.repositories.IRayonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class IRayonServiceIMP implements IRayonService{

    @Autowired
    IRayonRepository iRayonRepository;

    @Override
    public Rayon retrieveRayon(Long id) {
        return iRayonRepository.findById(id).orElse(null);
    }

    @Override
    public Rayon addRayon(Rayon r) {
        return iRayonRepository.save(r);
    }
}
